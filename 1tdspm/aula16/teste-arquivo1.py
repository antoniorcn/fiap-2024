texto = """
    public class TesteJava1 { 
        public static void main(String[] args) { 
            System.out.println("Teste 1 feito em Python");
        }
    }
"""

arquivo1 = open("./TesteJava1.java", "w")
# arquivo1.write(texto)
arquivo1.close()