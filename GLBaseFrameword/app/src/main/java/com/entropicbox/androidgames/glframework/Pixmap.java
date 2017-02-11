package com.entropicbox.androidgames.glframework;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;
import android.graphics.Bitmap;
import android.opengl.GLUtils;

public class Pixmap {
    private FloatBuffer vertexBuffer;   // buffer holding the vertices
    private FloatBuffer textureBuffer;  // buffer holding the texture coordinates
    public int x = 0; 
    public int y = 0;
    public int theta = 0;
    public int width;
    public int height;
    
    private float vertices[] = {
            -.5f, -.5f,  0.0f,        // V1 - bottom left
            -.5f,  .5f,  0.0f,        // V2 - top left
             .5f, -.5f,  0.0f,        // V3 - bottom right
             .5f,  .5f,  0.0f         // V4 - top right
    };
    private float texture[] = {        
            // Mapping coordinates for the vertices
   	        0.0f, 0.f,     // top left     (V2)
   	        0.0f, 1.0f,     // bottom left  (V1)
   	        1.f, 0.f,     // top right    (V4)
   	        1.f, 1.0f      // bottom right (V3)
   	};
    
    public Pixmap() {
        // a float has 4 bytes so we allocate for each coordinate 4 bytes
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertices.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        // allocates the memory from the byte buffer
        vertexBuffer = byteBuffer.asFloatBuffer();
        // fill the vertexBuffer with the vertices
        vertexBuffer.put(vertices);      
        // set the cursor position to the beginning of the buffer
        vertexBuffer.position(0);
        
        byteBuffer = ByteBuffer.allocateDirect(texture.length * 4);
   	    byteBuffer.order(ByteOrder.nativeOrder());
   	    textureBuffer = byteBuffer.asFloatBuffer();
   	    textureBuffer.put(texture);
   	    textureBuffer.position(0);
   	    //GLRenderer.renderStack.push(this);
    }
    
    public void draw(GL10 gl) {
    	gl.glLoadIdentity();
        // bind the previously generated texture
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);
         
        // Point to our buffers
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
         
        // Set the face rotation
        gl.glFrontFace(GL10.GL_CW);
         
        // Point to our vertex buffer
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textureBuffer);
        
        gl.glTranslatef(x+(width/2), y+(height/2), 0);        
        gl.glRotatef(theta, 0, 0, 1);
        gl.glScalef(width, height, 0.0f);
        
        // Draw the vertices as triangle strip
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertices.length / 3);
 
        //Disable the client state before leaving
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);    
    }
    
    /** The texture pointer */
   	private int[] textures = new int[1];
   	
   	public void loadGLTexture(GL10 gl, Bitmap bitmap) {
   		
   	    // generate one texture pointer
   	    gl.glGenTextures(1, textures, 0);
   	    // ...and bind it to our array
   	    gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);
   	     
   	    // create nearest filtered texture
   	    gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
   	    gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
   	     
   	    // Use Android GLUtils to specify a two-dimensional texture image from our bitmap
   	    GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
   	    
   	    //	Get Width and Height
   	    this.width = bitmap.getWidth();
   	    this.height = bitmap.getHeight();
   	    
   	}

   	public void clear(GL10 gl) {
   		gl.glDeleteTextures(1, textures, 0);
   	}
}
