/*     */ package search.io;
/*     */ import java.io.*;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ 
/*     */ public class TextIO {
/*     */   public static boolean writeStringToFile(String paramString, File paramFile) {
/*  17 */     boolean bool = false;
/*     */     try {
/*  19 */       FileOutputStream fileOutputStream = new FileOutputStream(paramFile);
/*  20 */       OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
/*  21 */       BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
/*  22 */       writeStringToStream(paramString, bufferedWriter);
/*  23 */       bufferedWriter.close();
/*  24 */       outputStreamWriter.close();
/*  25 */       fileOutputStream.close();
/*  26 */       bool = true;
/*     */     }
/*  28 */     catch (Exception exception) {}
/*  29 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean writeStringToURL(String paramString, URL paramURL) throws Exception {
/*  37 */     boolean bool = false;
/*     */     try {
/*  39 */       HttpURLConnection httpURLConnection = (HttpURLConnection)paramURL.openConnection();
/*  40 */       httpURLConnection.setDoOutput(true);
/*  41 */       httpURLConnection.setRequestMethod("PUT");
/*     */       
/*  43 */       PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
/*  44 */       printWriter.print(paramString);
/*  45 */       printWriter.flush();
/*  46 */       printWriter.close();
/*     */ 
/*     */       
/*  49 */       String str = httpURLConnection.getResponseMessage();
/*  50 */       if (str.equals("OK")) bool = true; 
/*  51 */       httpURLConnection.disconnect();
/*     */     }
/*  53 */     catch (IOException iOException) {}
/*  54 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void writeStringToStream(String paramString, BufferedWriter paramBufferedWriter) throws Exception {
/*  60 */     if (paramString != null) paramBufferedWriter.write(paramString);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String readStringFromFile(File paramFile) throws Exception {
/*  67 */     String str = "";
/*  68 */     if (paramFile.exists()) {
/*  69 */       FileInputStream fileInputStream = new FileInputStream(paramFile);
/*  70 */       InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
/*  71 */       BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
/*  72 */       str = readStringFromStream(bufferedReader);
/*  73 */       bufferedReader.close();
/*  74 */       inputStreamReader.close();
/*  75 */       fileInputStream.close();
/*     */     } 
/*  77 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String readStringFromURL(URL paramURL) throws Exception {
/*  84 */     String str = "";
/*     */     try {
/*  86 */       InputStream inputStream = (InputStream)paramURL.getContent();
/*  87 */       InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
/*  88 */       BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
/*  89 */       str = readStringFromStream(bufferedReader);
/*  90 */       bufferedReader.close();
/*  91 */       inputStreamReader.close();
/*     */     } catch (IOException iOException) {
/*  93 */       System.out.println("Failed to read from " + paramURL);
/*  94 */     }  return str;
/*     */   }
/*     */   
/*     */   private static String readStringFromStream(BufferedReader paramBufferedReader) {
/*  98 */     StringBuffer stringBuffer = new StringBuffer("");
/*     */     try {
/*     */       String str;
/* 101 */       while ((str = paramBufferedReader.readLine()) != null) {
/* 102 */         stringBuffer.append(str);
/* 103 */         stringBuffer.append('\n');
/*     */       }
/*     */     
/* 106 */     } catch (IOException iOException) {
/* 107 */       iOException.printStackTrace();
/* 108 */       System.out.println("Problem trying to read a string from stream");
/* 109 */       System.out.println(iOException);
/*     */     } 
/* 111 */     return new String(stringBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean deleteFile(File paramFile) {
/* 120 */     boolean bool = true;
/* 121 */     if (paramFile.exists()) {
/* 122 */       bool = paramFile.delete();
/* 123 */       if (paramFile.exists()) {
/* 124 */         bool = false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 129 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean deleteURL(URL paramURL) {
/* 136 */     boolean bool = false;
/*     */     
/* 138 */     try { URLConnection uRLConnection = paramURL.openConnection();
/* 139 */       uRLConnection.setDoOutput(true);
/* 140 */       uRLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
/* 141 */       if (uRLConnection instanceof HttpURLConnection) {
/* 142 */         HttpURLConnection httpURLConnection = (HttpURLConnection)uRLConnection;
/* 143 */         httpURLConnection.setRequestMethod("DELETE");
/* 144 */         bool = true;
/*     */       }
/*     */        }
/* 147 */     catch (FileNotFoundException fileNotFoundException) {  }
/* 148 */     catch (IOException iOException) {  }
/* 149 */     catch (NullPointerException nullPointerException) {  }
/* 150 */     catch (Exception exception) {}
/* 151 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static File[] list(File paramFile, FilenameFilter paramFilenameFilter) {
/* 161 */     return paramFile.listFiles(paramFilenameFilter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static File[] list(File paramFile) {
/* 170 */     return paramFile.listFiles();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/*     */     try {
/* 179 */       URL uRL1 = new URL("http://ewall.mit.edu/phw/news/hello.html");
/* 180 */       URL uRL2 = new URL("http://ewall.mit.edu/phw/news/hello.html");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 190 */       writeStringToURL("Hello World X?", uRL1);
/* 191 */       System.out.println("Read " + readStringFromURL(uRL2));
/*     */     } catch (Exception exception) {
/* 193 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\shmue\OneDrive\IdeaProjects\ArtificialInteligence\lib\SearchDemonstration.jar!\search\io\TextIO.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */