package professorCode;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IOManager<T extends Object> {

    /**
     * Sets the file path that this IOManager will read and write an object from. This
     * file location will be used by {@link #read()} and {@link #write(Object)}
     * @param path The file location to be read and written to
     * @throws FileNotFoundException when the specified path can not be found.
     * @throws IllegalArgumentException When the specified path points to a folder/directory rather than a file
     */
    public void setPath(String path) throws FileNotFoundException, IllegalArgumentException;

    /**
     * The file path that is IOManager read and write an object from. This
     * file location will is used by {@link #read()} and {@link #write(Object)}.
     * This method may not return a null value. If the path is not set this should
     * return an empty string.
     * @param path The file location to be read and written to
     */
    public String getPath();

    /**
     * Reads the object saved in the file located at the path returned by {@link #getPath()}
     * @return An object saved in the file
     * @throws IOException When something goes wrong in the IO process
     * @throws ClassNotFoundException If the object located at the is a class that is not implemented
     * by this version of your software
     * @throws IllegalStateException If the file path has not been set yet
     */
    public T read() throws IOException, ClassNotFoundException, IllegalStateException;

    /**
     * Writes and object to saved at the file located at the path returned by {@link #getPath()}
     * @param object The object saved in the file
     * @throws IOException When something goes wrong in the IO process
     * @throws IllegalStateException If the file path has not been set yet
     */
    public void write(T object) throws IOException, IllegalStateException;

}
