package by.jonline.module5_1.task01.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;


public abstract class File {

	private String name;
	private Directory directory;
	private Path filePath;
	
	public File(String name) {
		this.name = name;
		directory = new Directory();
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public Directory getDirectory() {return directory;}
	public Path getPath() {return filePath;}
	
	public abstract void addTextToFile(String... text);
	public abstract void printFile();
	
	
	public boolean isExist() {
		return Files.exists(Paths.get(directory.getWay() + name));
	}

	public boolean isExist(String newName) {
		return Files.exists(Paths.get(directory.getWay() + newName));
	}

	public boolean isExistDirectory(String newName) {
		return Files.exists(Paths.get(directory.getWay()));
	}

	public void createFile() {

		if (isExistDirectory(directory.getWay())) {
			try {
				if (!isExist()) {
					filePath = Files.createFile(Paths.get(directory.getWay() + name));
					System.out.println(String.format("Создан файл \"%s\"", name));
				} else {
					System.out.println(String.format(
							"В папке \"%s\" такой файл \"%s\" уже существует. Текущий объект принимает управление этим файлом.",
							directory.getWay(), name));
					filePath = Paths.get(directory.getWay() + name);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Заданной директории не существует. Создаем новую");
			createDirectory(directory.getWay());
			if (isExistDirectory(directory.getWay())) {
				createFile();
			} else {
				return;
			}
		}
	}

	public void createDirectory(String way) {
		try {
			directory.setWay(way);
			Files.createDirectory(Paths.get(directory.getWay()));
		} catch (IOException e) {
			System.out.println(
					"Невозможно создать директорию \"" + directory.getWay() + " \". Проверьте вводимые данные");
		}
	}

	public void deleteFile() {
		try {
			if (isExist()) {
				Files.delete(filePath);
				System.out.println(String.format("Файл \"%s\" удален", name));
			} else {
				System.out.println(
						String.format("В папке \"%s\" такого файла \"%s\" не существует", directory.getWay(), name));
			}
		} catch (NullPointerException ee) {
			System.out.println("Текущий объект не может удалить этот файл.");
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void rename(String newName) {
		if (this.getClass().equals(TextFile.class)) {
			newName=newName+".txt";
		}
		try {
			if (!isExist(newName)) {
				filePath = Files.move(filePath, filePath.resolveSibling(newName));
				System.out.println(String.format("Файл \"%s\" переименован в \"%s\"", name, newName));
				name = newName;
			} else {
				System.out.println(String.format("Файл не переименован. Такой файл \"%s\" уже существует.", newName));
			}
		} catch (NoSuchFileException q) {
			System.out.println(String.format("Файл \"%s\" не переименован. Его нет в указаной папке.", name));
		} catch (NullPointerException ee) {
			System.out.println("Текущий объект не может переименовать этот файл.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
