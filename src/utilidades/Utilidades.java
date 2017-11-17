/*
 * Examen segundo parcial de Programacion Orientada a objetos
 * Nathan Almonte   2017-0600
 * Profesor. Juan Pablo
 */
package utilidades;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Utilidades {

 
    public static void main(String[] args) {
        
        //Metodo para leer en pantalla.
        InputStreamReader u_isr = new InputStreamReader(System.in);
        BufferedReader u_br  = new BufferedReader(u_isr);
        
        int opcion = 0;
        
        
        //Instancias de las diferentes clases
        MMatrices matriz = new MMatrices();
        TMatrices matrizT = new TMatrices();
        DiagMatrices matrizDiag = new DiagMatrices();
        UModa Cmoda = new UModa();
        ValCed VCed = new ValCed();
        TiempoFecha TFecha = new TiempoFecha();
        CalcularMCM CalMCM = new CalcularMCM();
        ConvertirNum ConvN = new ConvertirNum();
        
        
        
        //Menu de seleccion para las diferentes utilidades.
        try{
            
            //Borrar la pantalla.
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
        
            //Imprime el menu.
            System.out.print("(-----------=================-------------)\n");
            System.out.print("(-----------UTILIDADES NATHAN-------------)\n");
            System.out.print("(-----------=================-------------)\n");
            System.out.print("1. Multiplicaicon de dos matrices\n");
            System.out.print("2. Determinar la suma del cuadrado de la diagonal\n");
            System.out.print("3. Devolver la transpuesta de la matriz\n");
            System.out.print("4. Determinar la moda de un grupo de elementos\n");
            System.out.print("5. Determinar la cantidad de dias, mes y año de dos fechas\n");
            System.out.print("6. Determinar si una cedula es valida\n");
            System.out.print("7. Convertir un monto suministrado en letras\n");
            System.out.print("8. Determinar el MCM de varios numeros\n");
            System.out.print("9. Salir\n");
        
            System.out.print("\nSeleccione una opcion [1,2,3,4,5,6,7,8,9]: ");
            opcion = Integer.parseInt(u_br.readLine());
        
            switch (opcion){
                
                case 1:
                    ImprimirEncabezado();
                    matriz.AlmacenarMat();
                    Pause();
                    break;
                    
                case 2:
                    ImprimirEncabezado();
                    matrizDiag.CalDiagMat();
                    Pause();
                    break;
                    
                case 3:
                    ImprimirEncabezado();
                    matrizT.TransponerMat();
                    Pause();
                    break;
                    
                case 4:
                    ImprimirEncabezado();
                    Cmoda.ResolverModa();
                    Pause();
                    break;
                    
                case 5:
                    ImprimirEncabezado();
                    TFecha.CalTiempo();
                    Pause();
                    break;   
                    
                case 6:
                    ImprimirEncabezado();
                    VCed.VerificarCedula();
                    Pause();
                    break;
                    
                case 7:
                    ImprimirEncabezado();
                    ConvN.NumALetra();
                    Pause();
                    break;
                    
                case 8:
                    ImprimirEncabezado();
                    CalMCM.CalcuMCM();
                    Pause();
                    break;
                    
                default:
                    ImprimirEncabezado();
                    System.out.print("\nLa operacion es invalida");
                    Scanner s = new Scanner(System.in);
                    String string = s.nextLine();
                    break;                  
            }
        }
        catch (Exception e){
            
            System.out.println("Ha ocurrido un error en el sistema");
             
         }
                      
    }
     
    public static void ImprimirEncabezado(){
        
        //Borrar la pantalla
        System.out.flush();
        
        //Inprimir encabezado
        System.out.print("(-----------=================-------------)\n");
        System.out.print("(-----------UTILIDADES NATHAN-------------)\n");
        System.out.print("(-----------=================-------------)\n");
  
    }
    
    //Metodo para realizar una pausa.
    public static void Pause(){
        
        System.out.print("\n\nLa operacion fue realizada con exito! \n");
        System.out.print("Presione una tecla para continuar...");
        Scanner s = new Scanner(System.in);
        String string = s.nextLine();
    }
                          
}

//Clase para la opcion 1 (Calcular la multiplicacion de 2 matrices).
class MMatrices
{
    Scanner consola = new Scanner(System.in);
    InputStreamReader u_isr = new InputStreamReader(System.in);
    BufferedReader    u_br  = new BufferedReader(u_isr); 
    String m_cadena;
    
    //Atributos opcion 1 (Multiplicacion de matrices)
    public int mat_a[][];
    public int mat_b[][];
    public int mat_c[][];
    
    //Metodo para almacenar la matriz.
    
    public void AlmacenarMat (){
        mat_a = new int[10][10];
        mat_b = new int[10][10];
        
        
        //Definir la cantidad de filas y columnas
        try{
        System.out.print("Introduzca la cantidad de filas de las matrices: ");
        m_cadena = u_br.readLine();
        int m_filas = Integer.parseInt(m_cadena);
                         
        System.out.print("Introduzca la cantidad de columnas de las matrices: ");
        m_cadena = u_br.readLine();
        int m_columnas = Integer.parseInt(m_cadena);
                      
        
        //Rellena la matriz A suministrada por teclado
            for (int x=0; x < m_filas; x++) {
                for (int y=0; y < m_columnas; y++) {
                    System.out.println("Introduzca el elemento de la primera matriz [" + x + "," + y + "]");
                    mat_a[x][y] = consola.nextInt();
                }
            }
         
         //Rellena la matriz B sumunistrada por teclado.
           for (int x=0; x < m_filas; x++) {
                for (int y=0; y < m_columnas; y++) {
                    System.out.println("Introduzca el elemento de la segunda matriz [" + x + "," + y + "]");
                    mat_b[x][y] = consola.nextInt();
                    
                }
            } 
        //Multiplica las matrices.
        int[][] mat_c = new int[m_filas][m_columnas];
        // se comprueba si las matrices se pueden multiplicar
        if (mat_a[0].length == mat_b.length) {
            for (int i = 0; i < m_filas; i++) {
                for (int j = 0; j < m_columnas; j++) {
                    for (int k = 0; k < mat_a[0].length; k++) {
                    // aquí se multiplica la matriz
                        mat_c[i][j] += mat_a[i][k] * mat_b[k][j];
                    }
                }
            }
        }else
        {
          System.out.print("Las matrices no se pueden multiplicar");
        }
        
        //Se imprime la matriz en pantalla.
        System.out.println("\r\nMatriz Resultante:");
                 
         for (int v_cont_fila = 0; v_cont_fila < m_filas; v_cont_fila++)
           {
             System.out.println();
                
             for (int v_cont_col = 0; v_cont_col < m_columnas; v_cont_col++)
               System.out.print(mat_c[v_cont_fila][v_cont_col] + "  ");
           }
        }
        catch(Exception e)
        {
        }  
    }
  
    
    
    //Constructor de la clase MMatrices.
    public MMatrices()
    {
            
    }      
}

//Clase para calcular la suma del cuadrado de la diagonal principal de una matriz.

class DiagMatrices{
    
    Scanner entrada = new Scanner(System.in);
    
    int OrdenMat;
    int suma = 0;
    
    //Se ingresa el orden de la matriz
    
    public void CalDiagMat(){
    
    System.out.print("Ingrese el orden de la matriz: ");
    OrdenMat = entrada.nextInt();
    
    if (OrdenMat > 1){
        
        int [][] Matriz = new int [OrdenMat][OrdenMat];
        
        System.out.print("\nIngresa la matriz: \n");
        for (int filas = 0; filas < OrdenMat; filas++) {
            
                for (int columnas = 0; columnas < OrdenMat; columnas++) {
                    System.out.print("Ingrese el valor ["+ filas + ","+ columnas + "] --> ");
                    Matriz[filas][columnas] = entrada.nextInt();
                } 
        }
        
        System.out.println("\n");
            System.out.println("\t Matriz cargada por teclado: ");           
            for (int filas = 0; filas < OrdenMat; filas++) {                
                System.out.println("");               
                for (int columnas = 0; columnas < OrdenMat; columnas++) {                   
                    System.out.print("\t"+ Matriz[filas][columnas]);
                }
            }
            
             for (int ordMatriz = 0; ordMatriz < OrdenMat; ordMatriz++) {
                
                suma+= Math.pow(Matriz[ordMatriz][ordMatriz],2);
            }
            
            System.out.println("\n\n\n>>> La suma es igual a " + suma + ".\n");
    }

    
    }
    public DiagMatrices()
    {
    
    }
}

//Clase para la opcion 3 (Transponer una matriz)
class TMatrices{
    
    Scanner consola = new Scanner(System.in);
    InputStreamReader u_isr = new InputStreamReader(System.in);
    BufferedReader    u_br  = new BufferedReader(u_isr); 
    String m_cadena;
    
    //Atributos opcion 3 (Transponer una matriz)
    public int mat_a[][];
    
    
     //Metodo para almacenar la matriz.
    
    public void TransponerMat (){
        mat_a = new int[10][10];
        int[][] matrizT = new int[mat_a[0].length][mat_a.length];
        
        
        //Definir la cantidad de filas y columnas
        try{
        System.out.print("Introduzca la cantidad de filas de las matrices: ");
        m_cadena = u_br.readLine();
        int m_filas = Integer.parseInt(m_cadena);
                         
        System.out.print("Introduzca la cantidad de columnas de las matrices: ");
        m_cadena = u_br.readLine();
        int m_columnas = Integer.parseInt(m_cadena);
                      
        
        //Rellena la matriz A suministrada por teclado
            for (int x=0; x < m_filas; x++) {
                for (int y=0; y < m_columnas; y++) {
                    System.out.println("Introduzca el elemento de la matriz [" + x + "," + y + "]");
                    mat_a[x][y] = consola.nextInt();
                }
            }
            
         //Transponer la matriz.
             for (int x=0; x < mat_a.length; x++) {
                for (int y=0; y < mat_a[x].length; y++) {
                    matrizT[y][x] = mat_a[x][y];
                }
            }
             
          //Se imprime la matriz en pantalla.
            System.out.println("\r\nMatriz Resultante:");
                 
            for (int v_cont_fila = 0; v_cont_fila < m_filas; v_cont_fila++)
                {
                System.out.println();
                
                for (int v_cont_col = 0; v_cont_col < m_columnas; v_cont_col++)
                    System.out.print(mat_a[v_cont_fila][v_cont_col] + "  ");
           }
            
            //Se imprime la matriz transpuesta en pantalla.
            System.out.println("\r\nMatriz Transpuesta:");
                 
            for (int v_cont_fila = 0; v_cont_fila < m_filas; v_cont_fila++)
                {
                System.out.println();
                
                for (int v_cont_col = 0; v_cont_col < m_columnas; v_cont_col++)
                    System.out.print(matrizT[v_cont_fila][v_cont_col] + "  ");
                }
        }
        catch(Exception e)
        {
        }  
    }
    
    //Constructor de la clase TMatrices,
    public TMatrices()
    
    {
        
    }   
}

class UModa{
    
    InputStreamReader u_isr = new InputStreamReader(System.in);
    BufferedReader    u_br  = new BufferedReader(u_isr); 
    String u_cadena;
    
    //Atributos de la clase Moda.
    int elementos;
    int valor;
    
    //Metodo para resolver la moda.
    public void ResolverModa(){
        
        try
        {      
        //Se definen la cantidad de elementos a utilizar.
        Scanner entrada = new Scanner (System.in);
        System.out.print ("Ingrese la cantidad de elementos para comparar: ");

        elementos = entrada.nextInt(); 
            
        int[] ModaA = new int[elementos];

        // Conseguir valores para arreglo
            
        for (int x=0; x < ModaA.length; x++){

            System.out.print ("Dame valor " + (x + 1) + ": -> ");	
            valor = entrada.nextInt();
            ModaA[x] = valor;
        }
      //Mapa creado para ir cargando cada numero con un key.
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();				
     
        for (int elemento: ModaA){			
            if (m.containsKey(elemento))					
                m.put(elemento,m.get(elemento)+1);
            else
                m.put(elemento,1);			        
        }
            
        //Se crea un ArrayList para ir guardando las repeticiones.   
        int repeticiones = 0;
        List<Integer> moda = new ArrayList<Integer>();
        
        //Se recorre el mapa utilizando la clave Entry.
        Iterator<Entry<Integer, Integer>> iter = m.entrySet().iterator();
        
        //Se hace una comprobacion de la frecuencia.
        while (iter.hasNext()) {	      
            Entry<Integer,Integer> e = iter.next();	    	
     
        if (e.getValue() > repeticiones) {
            moda.clear();
            moda.add(e.getKey());
            repeticiones = e.getValue();
        } else if (e.getValue() == repeticiones)
            moda.add(e.getKey());	    	
     
        }
        
        //Hacemos la comprobacion de la moda.
        if (moda.size() == ModaA.length)
            System.out.println("No hay moda");
        else
            System.out.println("La moda de la distribución es " + moda);
        }
        catch(Exception e)
        {
        }
    }
    
    
    //Constructor de la clase Moda.
    public UModa()
    
    {
        
    }
}

//Metodo para calcular el tiempo entre dos fechas.
class TiempoFecha{
    
    
    public static void CalTiempo(){
        
        
        Scanner entrada = new Scanner(System.in);        
        

        int v_Dias=0, v_Meses = 0, v_Año = 0, v_Dia = 0, Diafinal, Mesfinal, Añofinal, Diainicial, Mesinicial, Añoinicial;
       
        //----------------------------------------------------------------------
        
        System.out.println("\t<-- Fecha Inicial -->\n\n");
        
        System.out.print("Introduzca el año --> "); 
        
            Añoinicial = entrada.nextInt();
        
        System.out.print("Introduzca el mes --> "); 
        
            Mesinicial = entrada.nextInt();
        
        System.out.print("Introduzca el día --> "); 
        
            Diainicial = entrada.nextInt();
        
        //----------------------------------------------------------------------
            
        System.out.println("\n\n\n\t<-- Fecha Final -->\n\n");
      
        System.out.print("Introduzca el año --> "); 
        
            Añofinal = entrada.nextInt();
        
        System.out.print("Introduzca el mes --> "); 
        
            Mesfinal = entrada.nextInt();
            
        System.out.print("Introduzca el día --> "); 
        
            Diafinal = entrada.nextInt();
           
        //----------------------------------------------------------------------
        
        if(Diafinal > 31 || Diainicial >31 || Mesfinal > 12 || Mesinicial > 12 || Añofinal <1 || Añoinicial < 1){
            
            System.err.println("\n\nHa introducido la fecha de manera incorrecta.");
           
        }
        
        else{
            if(Diafinal == Diainicial && Mesfinal == Mesinicial && Añofinal == Añoinicial){
                
                System.out.println("\n\nHa introducida la misma fecha en ambos lados. Por tanto, es cero.\n");
                System.exit(0);
                
            }else{
                
                if(Mesfinal == 1 || Mesfinal == 3 || Mesfinal == 5|| Mesfinal == 7 || Mesfinal == 8 || Mesfinal == 10 || Mesfinal == 12 ){
                    v_Dias = 31;
                }
                
                else {
                  if(Mesfinal == 4 || Mesfinal == 6 || Mesfinal == 9 || Mesfinal ==11){
                      v_Dias = 30;
                    }
                  
                  else{
                        if(Mesfinal == 2)
                          v_Dias = 28;
                    }
                }
            }
        }
    
        if(Añofinal >= Añoinicial && Mesfinal >= Mesinicial && Diafinal >= Diainicial){ 
          v_Dia = Diafinal - Diainicial;
          v_Meses = Mesfinal - Mesinicial;
          v_Año = Añofinal - Añoinicial;
          
        }else{
            if(Añofinal >= Añoinicial && Mesfinal < Mesinicial && Diafinal >= Diainicial){
                
            Mesfinal = Mesfinal + 12; 
            Añofinal = Añofinal - 1;
            v_Dia = Diafinal - Diainicial;
            v_Meses = Mesfinal - Mesinicial;
            v_Año = Añofinal - Añoinicial;
            }
            
            else{
                
                if(Añofinal >= Añoinicial && Mesfinal >= Mesinicial && Diafinal < Diainicial){
                    
                    Diafinal = Diafinal + v_Dias;                     
                    Mesfinal = Mesfinal - 1; 
                    v_Dia = Diafinal - Diainicial;
                    v_Meses = Mesfinal - Mesinicial;
                    v_Año = Añofinal - Añoinicial;
                    
                }
                
                else{
                    
                    if(Añofinal >= Añoinicial && Mesfinal < Mesinicial && Diafinal < Diainicial){ 
                        
                        Diafinal = Diafinal + v_Dias; 
                        Mesfinal = (Mesfinal - 1) + 12; 
                        v_Año = v_Año - 1;         
                        v_Dia = Diafinal - Diainicial;
                        v_Meses = Mesfinal - Mesinicial;
                        v_Año = Añofinal - Añoinicial;
                    }
                }
            }
        }
        String Primero, Segundo, Tercero;
        
        if(v_Dia == 1){
            
            Primero = "día ";
        }
        
        else{Primero = "días ";}
        
        if(v_Meses == 1){
            Segundo = "mes";
        }
        
        else{Segundo = "meses";}
        
        if(v_Año == 1){
        Tercero = "año";}
        
        else{Tercero ="años";}
        System.out.println("\n\n>>> El tiempo transcurridos entre las dos fechas es: "+v_Año+" "+Tercero+ ", "+v_Meses+" "+Segundo+" Y "+v_Dia+" "+Primero+".\n\n");
    }
    
    
    
    public TiempoFecha(){
        
    }
}



//Clase para la verificacion de la cedula (Opcion 6).
class ValCed{
    
    //Metodo utilizado para poder validar la cedula.
    public static void VerificarCedula(){
        
        Scanner entrada = new Scanner(System.in);
        
        int Suma = 0 , ultimoDigito = 0;
        String Cedula; 
        
        System.out.print("Introduzca su número de cédula que va a verificar: "); Cedula = entrada.next();
        System.out.println("");
        
        if(Cedula.length()!=11){ 
            
            System.out.println(">>> La cédula no es válida.\n\n");
            System.exit(0);
            
        }else{
            
            int[] Arrayalgortimo = {1,2,1,2,1,2,1,2,1,2};
            
            ultimoDigito = Integer.parseInt(Cedula.substring(10,11));
            
            for(int i = 0; i < (Cedula.length() - 1); i++){
                int MultiplicarAlgoritmo = Integer.parseInt(Cedula.substring(i, i +1)) * Arrayalgortimo[i];
                Suma = Suma + ((MultiplicarAlgoritmo%10)+(MultiplicarAlgoritmo/10)); 
            }
        }
        
        if((Suma % 10 == 0) && (Suma % 10 == ultimoDigito)){
            
          System.out.println(">>> La cédula es totalmente válida.\n\n");}
        
        else{
            //Se saca el mod 10 y le restamos 10 y nos da el ultimo digito para la comprobacion.
            if ((10 - (Suma % 10)) == ultimoDigito){
                System.out.println(">>> La cédula es totalmente válida.\n\n");}
            
            else {System.out.println(">>> La cédula no es válida.\n\n");
            
            }
        }
    }   
   
    public ValCed(){
    
}
}

class CalcularMCM {
    
    
    public static void CalcuMCM(){
        
        
        Scanner entrada = new Scanner(System.in);
        int MCM = 1;
        int v_Numero=1;
        
        
        
        System.out.print("Ingrese la cantidad de numeros que desea evaluar: ");
        
        
        int cantidad = entrada.nextInt();
        
        if (cantidad < 2){
        
            System.out.println("\nLa cantidad de numeros a evaluar debe ser mayor a 1.\n");
            System.exit(0);
        }
	  
	int numeros[]=new int[cantidad];
        
        for(int conteo = 0 ; conteo < cantidad; conteo++){
            
            System.out.print("Introduzca el valor #"+(conteo + 1) + " -> ");
            numeros[conteo]=entrada.nextInt();
        }
        
        while (v_Numero > 0){
            MCM++;
            v_Numero = 0;
            for(int cont=0; cont < cantidad; cont++){
                if (MCM % numeros[cont]!=0){
                    v_Numero = v_Numero + 1;
                }
            } 
        }   
        System.out.println("");
        System.out.println("El mínimo común múltiplo de los " +cantidad+" números introducidos es "+MCM+". \n\n");
        
        
        }

    public CalcularMCM(){
        
        
      
    }
}



//Clase para poder convertir numero a letra (Opcion 7)
class n2t {
	
    
        private int flag;
	public int numero;
	public String importe_parcial;
	public String num;
	public String num_letra;
	public String num_letras;
	public String num_letram;
	public String num_letradm;
	public String num_letracm;
	public String num_letramm;
	public String num_letradmm;
	
	public n2t(){
		numero = 0;
		flag=0;
	}
	public n2t(int n){
		numero = n;
		flag=0;
	}

	
	private String unidad(int numero){
		
		switch (numero){
		case 9:
				num = "nueve";
				break;
		case 8:
				num = "ocho";
				break;
		case 7:
				num = "siete";
				break;
		case 6:
				num = "seis";
				break;
		case 5:
				num = "cinco";
				break;
		case 4:
				num = "cuatro";
				break;
		case 3:
				num = "tres";
				break;
		case 2:
				num = "dos";
				break;
		case 1:
				if (flag == 0)
					num = "uno";
				else 
					num = "un";
				break;
		case 0:
				num = "";
				break;
		}
		return num;
	}
	
	private String decena(int numero){
	
		if (numero >= 90 && numero <= 99)
		{
			num_letra = "noventa ";
			if (numero > 90)
				num_letra = num_letra.concat("y ").concat(unidad(numero - 90));
		}
		else if (numero >= 80 && numero <= 89)
		{
			num_letra = "ochenta ";
			if (numero > 80)
				num_letra = num_letra.concat("y ").concat(unidad(numero - 80));
		}
		else if (numero >= 70 && numero <= 79)
		{
			num_letra = "setenta ";
			if (numero > 70)
				num_letra = num_letra.concat("y ").concat(unidad(numero - 70));
		}
		else if (numero >= 60 && numero <= 69)
		{
			num_letra = "sesenta ";
			if (numero > 60)
				num_letra = num_letra.concat("y ").concat(unidad(numero - 60));
		}
		else if (numero >= 50 && numero <= 59)
		{
			num_letra = "cincuenta ";
			if (numero > 50)
				num_letra = num_letra.concat("y ").concat(unidad(numero - 50));
		}
		else if (numero >= 40 && numero <= 49)
		{
			num_letra = "cuarenta ";
			if (numero > 40)
				num_letra = num_letra.concat("y ").concat(unidad(numero - 40));
		}
		else if (numero >= 30 && numero <= 39)
		{
			num_letra = "treinta ";
			if (numero > 30)
				num_letra = num_letra.concat("y ").concat(unidad(numero - 30));
		}
		else if (numero >= 20 && numero <= 29)
		{
			if (numero == 20)
				num_letra = "veinte ";
			else
				num_letra = "veinti".concat(unidad(numero - 20));
		}
		else if (numero >= 10 && numero <= 19)
		{
			switch (numero){
			case 10:

				num_letra = "diez ";
				break;

			case 11:

				num_letra = "once ";
				break;

			case 12:

				num_letra = "doce ";
				break;

			case 13:

				num_letra = "trece ";
				break;

			case 14:

				num_letra = "catorce ";
				break;

			case 15:
			
				num_letra = "quince ";
				break;
			
			case 16:
			
				num_letra = "dieciseis ";
				break;
			
			case 17:
			
				num_letra = "diecisiete ";
				break;
			
			case 18:
			
				num_letra = "dieciocho ";
				break;
			
			case 19:
			
				num_letra = "diecinueve ";
				break;
			
			}	
		}
		else
			num_letra = unidad(numero);

	return num_letra;
	}	

	private String centena(int numero){
		if (numero >= 100)
		{
			if (numero >= 900 && numero <= 999)
			{
				num_letra = "novecientos ";
				if (numero > 900)
					num_letra = num_letra.concat(decena(numero - 900));
			}
			else if (numero >= 800 && numero <= 899)
			{
				num_letra = "ochocientos ";
				if (numero > 800)
					num_letra = num_letra.concat(decena(numero - 800));
			}
			else if (numero >= 700 && numero <= 799)
			{
				num_letra = "setecientos ";
				if (numero > 700)
					num_letra = num_letra.concat(decena(numero - 700));
			}
			else if (numero >= 600 && numero <= 699)
			{
				num_letra = "seiscientos ";
				if (numero > 600)
					num_letra = num_letra.concat(decena(numero - 600));
			}
			else if (numero >= 500 && numero <= 599)
			{
				num_letra = "quinientos ";
				if (numero > 500)
					num_letra = num_letra.concat(decena(numero - 500));
			}
			else if (numero >= 400 && numero <= 499)
			{
				num_letra = "cuatrocientos ";
				if (numero > 400)
					num_letra = num_letra.concat(decena(numero - 400));
			}
			else if (numero >= 300 && numero <= 399)
			{
				num_letra = "trescientos ";
				if (numero > 300)
					num_letra = num_letra.concat(decena(numero - 300));
			}
			else if (numero >= 200 && numero <= 299)
			{
				num_letra = "doscientos ";
				if (numero > 200)
					num_letra = num_letra.concat(decena(numero - 200));
			}
			else if (numero >= 100 && numero <= 199)
			{
				if (numero == 100)
					num_letra = "cien ";
				else
					num_letra = "ciento ".concat(decena(numero - 100));
			}
		}
		else
			num_letra = decena(numero);
		
		return num_letra;	
	}	

	private String miles(int numero){
		if (numero >= 1000 && numero <2000){
			num_letram = ("mil ").concat(centena(numero%1000));
		}
		if (numero >= 2000 && numero <10000){
			flag=1;
			num_letram = unidad(numero/1000).concat(" mil ").concat(centena(numero%1000));
		}
		if (numero < 1000)
			num_letram = centena(numero);
		
		return num_letram;
	}		

	private String decmiles(int numero){
		if (numero == 10000)
			num_letradm = "diez mil";
		if (numero > 10000 && numero <20000){
			flag=1;
			num_letradm = decena(numero/1000).concat("mil ").concat(centena(numero%1000));		
		}
		if (numero >= 20000 && numero <100000){
			flag=1;
			num_letradm = decena(numero/1000).concat(" mil ").concat(miles(numero%1000));		
		}
		
		
		if (numero < 10000)
			num_letradm = miles(numero);
		
		return num_letradm;
	}		

	private String cienmiles(int numero){
		if (numero == 100000)
			num_letracm = "cien mil";
		if (numero >= 100000 && numero <1000000){
			flag=1;
			num_letracm = centena(numero/1000).concat(" mil ").concat(centena(numero%1000));		
		}
		if (numero < 100000)
			num_letracm = decmiles(numero);
		return num_letracm;
	}		

	private String millon(int numero){
		if (numero >= 1000000 && numero <2000000){
			flag=1;
			num_letramm = ("Un millon ").concat(cienmiles(numero%1000000));
		}
		if (numero >= 2000000 && numero <10000000){
			flag=1;
			num_letramm = unidad(numero/1000000).concat(" millones ").concat(cienmiles(numero%1000000));
		}
		if (numero < 1000000)
			num_letramm = cienmiles(numero);
		
		return num_letramm;
	}		
	
	private String decmillon(int numero){
		if (numero == 10000000)
			num_letradmm = "diez millones";
		if (numero > 10000000 && numero <20000000){
			flag=1;
			num_letradmm = decena(numero/1000000).concat("millones ").concat(cienmiles(numero%1000000));		
		}
		if (numero >= 20000000 && numero <100000000){
			flag=1;
			num_letradmm = decena(numero/1000000).concat(" milllones ").concat(millon(numero%1000000));		
		}
		
		
		if (numero < 10000000)
			num_letradmm = millon(numero);
		
		return num_letradmm;
	}		

	
	public String convertirLetras(int numero){
		num_letras = decmillon(numero);
		return num_letras;
	} 	
}


class ConvertirNum{
    
     public static void NumALetra (){
        
        try {
        n2t numero;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	int num;
	String res;
        System.out.print("Ingrese numero : ");
        num = Integer.parseInt(in.readLine());
		numero = new n2t(num);
		res = numero.convertirLetras(num);
		System.out.print(res);
		System.out.println("\n");
                
                
        }catch(Exception e){
    
        }
    }
    
    
    
    public ConvertirNum(){
        
        
    }

   
}

