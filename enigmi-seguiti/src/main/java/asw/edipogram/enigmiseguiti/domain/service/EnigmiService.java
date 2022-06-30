package asw.edipogram.enigmiseguiti.domain.service;

import asw.edipogram.enigmiseguiti.domain.entity.Enigma;

import java.util.*;

public interface EnigmiService {

	Collection<Enigma> getEnigmiByTipi(Collection<String> tipi);

	Enigma saveEnigma(Enigma enigmaVO);

}
