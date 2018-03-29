package tools;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Random;
import java.util.Scanner;
import java.io.InputStreamReader;

import Iohandle.IOhandle;

public class RandomSample {
	// 读取指定行
	static void readLineVarFile(String fileName, int lineNumber, BufferedWriter bw) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String line = reader.readLine();
		int num = 0;
		while (line != null) {
			if (lineNumber == ++num) {
				System.out.println("line   " + lineNumber + ":   " + line);
				bw.write(line);
				bw.newLine();
				bw.flush();
			}
			line = reader.readLine();
		}
		reader.close();
	}

	// 文件内容的总行数。
	static int getTotalLines(String fileName) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		LineNumberReader reader = new LineNumberReader(in);
		String s = reader.readLine();
		int lines = 0;
		while (s != null) {
			lines++;
			s = reader.readLine();
		}
		reader.close();
		in.close();
		return lines;
	}

	public static void main(String[] args) throws IOException {
		// 读取文件
		String fileName = "D:\\Rakuten_calorie\\YasaiWOMessy.txt";
		float gailv =(float) 0.007509;
		String OutputPath = "D:\\Rakuten_calorie\\YasaiSample.txt";
		IOhandle iOhandle = new IOhandle();
		BufferedWriter bw = iOhandle.FileWriterContinue(OutputPath);
		// 获取文件的内容的总行数
		int totalNo = getTotalLines(fileName);
		System.out.println("There are " + totalNo + " lines in the text!");
		int del_num = (int) (totalNo * gailv);
		System.out.println("There are "+del_num+" lines that are sampled!");
		for (int i = 0; i < del_num; i++) {
			Random rand = new Random();
			// 指定读取的行号
			int lineNumber = (int) (rand.nextDouble() * totalNo);
			// 读取指定行的内容
			readLineVarFile(fileName, lineNumber,bw);
		}
	}
}
