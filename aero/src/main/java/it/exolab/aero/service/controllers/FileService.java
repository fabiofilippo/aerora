package it.exolab.aero.service.controllers;

import it.exolab.aero.airport_01Model.models.entities.Airplane;
import it.exolab.aero.repository.AirplaneRepository;
import it.exolab.aero.utils.customUtils.constants.airport_01.DataPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class FileService {

	private static final String CLASSNAME = "FileService";

	public String findAll() throws Exception {
		try {
			Path path = Paths.get(DataPaths.FILE_DATA_PATH + "aeroporti.txt");
			String contenuto = String.join(" ", Files.readAllLines(path));

			contenuto = contenuto.replace("\n", "").replace("\r", "").replace("\t", "");;

			return contenuto;
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("errore durante la lettura del file: " + e.getMessage());
		}
	}


}
