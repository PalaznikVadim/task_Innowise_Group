import java.io.*;
import java.util.ArrayList;
import java.util.List;

class WriteAndReadJSONFile {
    private File json;
    public WriteAndReadJSONFile(){
        String separator=File.separator;
        String filePath="files/";
                //separator+"files"+separator;
        json=new File(filePath+"JSON.txt");
    }
    public void writeToJson(String str){
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(json, true)));
            writer.println(str);
            writer.flush();
            writer.close();
            System.out.println("Файл успешно записан!\n");
        }
        catch(IOException ex){
            ex.printStackTrace();
            System.out.println("Ошибка записи файла!\n");
        }

    }

    public List<String> readFromJson(){
        List<String> list=new ArrayList<String>();

        FileReader fr = null;
        try {
            fr = new FileReader(json);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(fr);
        String line = null;
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            list.add(line);
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clearFile();

        return list;
    }

    public void clearFile(){

            json.delete();

    }

   // public
}
