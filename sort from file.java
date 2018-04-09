 String inputFile = "20k.txt";
 String outputFile = "sort.txt";

 FileReader fileReader = new FileReader(inputFile);
 BufferedReader bufferedReader = new BufferedReader(fileReader);
 String inputLine;
 List<String> lineList = new ArrayList<String>();
 while ((inputLine = bufferedReader.readLine()) != null) {
     lineList.add(inputLine);
 }
 fileReader.close();

 Collections.sort(lineList);

 FileWriter fileWriter = new FileWriter(outputFile);
 PrintWriter out = new PrintWriter(fileWriter);
 for (String outputLine : lineList) {
     out.println(outputLine);
 }
 out.flush();
 out.close();
 fileWriter.close();