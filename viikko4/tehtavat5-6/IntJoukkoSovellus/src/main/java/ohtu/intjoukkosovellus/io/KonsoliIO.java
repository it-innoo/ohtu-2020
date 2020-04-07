/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.intjoukkosovellus.io;

import java.util.Scanner;

/**
 *
 * @author jukka
 */
public class KonsoliIO implements IO {

    private Scanner lukija;

    public KonsoliIO() {
        lukija = new Scanner(System.in);
    }
    
    @Override
    public int nextInt() {
        return Integer.valueOf(lukija.nextLine());
    }

    @Override
    public void print(String m) {
        System.out.println(m);
    }

    @Override
    public String nextLine() {
        return lukija.nextLine();
    }

    @Override
    public int nextInt(String kehote) {
        print(kehote);
        return nextInt();
    }

    @Override
    public String nextLine(String kehote) {
        print(kehote);
        return nextLine();
    }
    
}
