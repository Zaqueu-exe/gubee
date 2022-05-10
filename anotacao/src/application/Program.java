package application;

import model.dao.DaoFactory;
import model.dao.PessoaDao;
import model.dao.PessoaManager;
import model.dao.impl.PessoaDaoCache;
import model.entities.Pessoa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;


public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        PessoaDao pessoaDao = DaoFactory.createPessoaDao();
        PessoaDao pCache = new PessoaDaoCache(pessoaDao);
        PessoaManager pManeger = new PessoaManager(pCache);

        HashSet<Pessoa> pessoas = pManeger.findAll();

        for(Pessoa p: pessoas){
            System.out.println(p);
        }
       // pManeger.insert(new Pessoa(null, "Gustavo", sdf.parse("15-12-2019")));
        /*HashSet<Pessoa> pessoas1 = pManeger.findAll();

        for(Pessoa p: pessoas1){
            System.out.println(p);
        }*/
    }
}
