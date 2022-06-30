package asw.edipogram.enigmiseguiti.domain.service;

import asw.edipogram.enigmiseguiti.domain.entity.Enigma;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaCollectionOutVO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaOutVO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaVO;

import java.util.*;

public interface EnigmiService {

	EnigmaCollectionOutVO getEnigmiByTipi(Collection<String> tipi);

	EnigmaOutVO saveEnigma(EnigmaVO enigmaVO);

}
