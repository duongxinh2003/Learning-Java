package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import day11.RandomData;
import day7.Information;

public class IOController {

	public MyList myList;

	public IOController(MyList myList) {
		this.myList = myList;
	}

	public void createThreads(Object object) {
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						synchronized (myList) {
							ArrayList<MyData> data = myList.getList();
							for (int j = 1; j <= data.size() / 1000; j++) {
								CreateWriteFile createWriteFile = new CreateWriteFile();
								if(j < data.size()/1000) {
									ArrayList<MyData> subList = new ArrayList<>(data.subList((j - 1) * 1000, j * 1000));
										createWriteFile = new CreateWriteFile();
										System.out.println(subList.toString());
										createWriteFile.writeFile(subList);
								} else if (j > 1 && j == data.size() / 1000) {
									ArrayList<MyData> subListMod = new ArrayList<>(
											data.subList(j * 1000, ((j*1000)+data.size() % 1000)));
										System.out.println(subListMod.toString());
										createWriteFile.writeFile(subListMod);
										break;
								}
							}
							data.removeAll(data);
							myList.notify();
						}

					}
				}
			}).start();
		}
	}

}
