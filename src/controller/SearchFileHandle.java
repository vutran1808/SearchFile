/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import repository.ISearchFileRespository;
import repository.SearchFileRespository;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class SearchFileHandle extends Menu {

    static String[] mc = {"Count Word In File", "Find File By Word", "Exit"};
    ISearchFileRespository mn;
    
    public SearchFileHandle() {
        super("Word Program", mc);
        mn = new SearchFileRespository();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> mn.coutWord();
            case 2 -> mn.seardFile();
            case 3 -> System.exit(0);
        }
    }

}
