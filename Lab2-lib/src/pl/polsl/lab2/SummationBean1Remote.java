/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.lab2;

import javax.ejb.Remote;

/**
 *
 * @author 黑妹
 */
@Remote
public interface SummationBean1Remote {

    int add(int arg1, int arg2);
    
}
