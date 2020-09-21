/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

/**
 *This class is custom exception which was created to be 
 * used as exception in the program.
 * @author Qilin
 * @version 2.0
 */

public class MyException extends Exception {

    /** Constructor without parametric
     * 
     */
    public MyException() {
    }

    /** Constructor
     *	@param message display message
     */
    public MyException(String message) {
        super(message);
    }
}
