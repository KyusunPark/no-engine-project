import org.lwjgl.opengl.GL;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Main {
    public static void main(String[] args) {        
        glfwInit();
        long window = glfwCreateWindow(800, 600, "LWJGL", 0, 0);
        glfwSetWindowPos(window, 100, 200);
        
        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        GL.createCapabilities();
        glClearColor(0.1f, 0.1f, 0.1f, 0.1f);
        glfwShowWindow(window);
        
		double previousTime = glfwGetTime(); 
		double accumulator = 0.0;
		double fixedTimeStep = 1.0 / 60.0;
        
        while(!glfwWindowShouldClose(window)) {
        	glfwPollEvents();
			double currentTime = glfwGetTime();
			double deltaTime = currentTime - previousTime;
			previousTime = currentTime;
			accumulator = accumulator + deltaTime;
			
			while (accumulator >= fixedTimeStep) { 
			    accumulator = accumulator - fixedTimeStep;
			}
			
            glClear(GL_COLOR_BUFFER_BIT);
            glBegin(GL_TRIANGLES);
            	glColor3f(1.0f, 0.0f, 0.0f);
            	glVertex2f(-0.25f, -0.25f); 
            	glColor3f(0.0f, 1.0f, 0.0f);
            	glVertex2f(0.25f, -0.25f);
            	glColor3f(0.0f, 0.0f, 1.0f);
            	glVertex2f(0.0f, 0.25f);
            	glEnd();
            glfwSwapBuffers(window);
        }
        
        glfwDestroyWindow(window);
        glfwTerminate();
    }
}
