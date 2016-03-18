package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class principal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int x=JOptionPane.showOptionDialog(null, "Seleccione una Opcion", "Entrada", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Leer Archivo","Sacar porcentaje","Crear nuevo","Insterar Datos"}, "Leer Archivo");
		switch (x) {
		case 0:
			lectura();
			break;
		case 1:
			JOptionPane.showMessageDialog(null, promedio());
			break;
		case 2:
			nuevo();
			break;
		case 3:
			insertar();
			break;
		default:
			break;
		}
	}
	public static void lectura() throws IOException{
		File archivo= null;
		FileReader fr=null;
		BufferedReader br= null;
		try {
			archivo= new File("C:\\Users\\Clases\\workspace\\Archivos\\src\\lab1\\salarios.txt");
			fr=new FileReader(archivo);
			br=new BufferedReader(fr);
			String salario;
			String cadena="";
			JTextArea jta= new JTextArea(20,10);
			JScrollPane js= new JScrollPane(jta);
			while ((salario=br.readLine())!=null) {
				cadena=cadena+salario+"\n";
			}
			jta.setText(cadena);
			JOptionPane.showMessageDialog(null, jta);
			fr.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("No existe el archivo");
		}
	}
	public static double promedio() throws IOException{
		File archivo= null;
		FileReader fr=null;
		BufferedReader br= null;
		try {
			archivo= new File("C:\\Users\\Clases\\workspace\\Archivos\\src\\lab1\\salarios.txt");
			fr=new FileReader(archivo);
			br=new BufferedReader(fr);
			String salario;
			double sal=0,sum=0,c=0;
			while ((salario=br.readLine())!=null) {
				sal=Double.parseDouble(salario);
				sum+=sal;
				c++;
			}
			fr.close();
			double prom=sum/c;
			archivo= new File("C:\\Users\\Clases\\workspace\\Archivos\\src\\lab1\\salarios.txt");
			fr=new FileReader(archivo);
			br=new BufferedReader(fr);
			int n=0;
			while ((salario=br.readLine())!=null) {
				sal=Double.parseDouble(salario);
				if (sal>prom) {
					n++;
				}
			}
			return (n/c)*100;
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("No existe el archivo");
			return 0;
		}
	}
	public static void nuevo() throws IOException{
		File archivo= null;
		File nuvo=null;
		FileReader fr=null;
		BufferedReader br= null;
		FileWriter fw=null;
		BufferedWriter bw= null;
		try {
			archivo= new File("C:\\Users\\Clases\\workspace\\Archivos\\src\\lab1\\salarios.txt");
			nuvo= new File("C:\\Users\\Clases\\workspace\\Archivos\\src\\lab1\\nuevo.txt");
			fr=new FileReader(archivo);
			br=new BufferedReader(fr);
			fw=new FileWriter(nuvo);
			bw=new BufferedWriter(fw);
			String salario;
			double sal;
			while ((salario=br.readLine())!=null) {
				sal=Double.parseDouble(salario);
				if (sal>2*1600) {
					fw.write(salario+"\r\n");
				}
			}
			fr.close();
			fw.close();
			nuvo= new File("C:\\Users\\Clases\\workspace\\Archivos\\src\\lab1\\nuevo.txt");
			fr=new FileReader(nuvo);
			br=new BufferedReader(fr);
			String cadena="";
			JTextArea jta= new JTextArea(20,10);
			JScrollPane js= new JScrollPane(jta);
			while ((salario=br.readLine())!=null) {
				cadena=cadena+salario+"\n";
			}
			jta.setText(cadena);
			JOptionPane.showMessageDialog(null, jta);
			fr.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("No existe el archivo");
		}
	}
	public static void insertar() throws IOException{
		File archivo= null;
		File nuvo=null;
		FileReader fr=null;
		BufferedReader br= null;
		FileWriter fw=null;
		BufferedWriter bw= null;
		try {
			archivo= new File("C:\\Users\\Clases\\workspace\\Archivos\\src\\lab1\\salarios.txt");
			fr=new FileReader(archivo);
			br=new BufferedReader(fr);
			fw=new FileWriter(archivo,true);
			int n=0;
			String op=JOptionPane.showInputDialog(null, "Cuantos salarios desea ingresar");
			n=Integer.parseInt(op);
			String salario;
			for (int i = 0; i < n; i++) {
				salario=JOptionPane.showInputDialog(null,"Ingrese el dato");
				fw.write("\r\n"+salario);
			}
			fr.close();
			fw.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("No existe el archivo");
		}
	}
}
