/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.ScannerFactory;
import dataAccess.SearchFileDao;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class SearchFileRespository implements ISearchFileRespository {

    private ScannerFactory sc;

    public SearchFileRespository() {
        sc = new ScannerFactory();
    }

    @Override
    public void coutWord() {
        System.out.println("-----Count Word-----");
        File path = new File(sc.getFilePath("Enter Path: "));
        String word = sc.getString("Enter Word: ");
        int count = SearchFileDao.Instance().countOccurent(word, path);
        System.out.println("Bout: " + count);
    }

    @Override
    public void seardFile() {
        System.out.println("-----Find File By Word-----");
        File source = new File(sc.getFilePath("Enter Path: "));
        String word = sc.getString("Enter word: ");
        System.out.println("-----File Name-----");
        SearchFileDao.Instance().findFile(source, word).forEach(file -> {
            System.out.println("File name: " + file);
        });
    }

}
