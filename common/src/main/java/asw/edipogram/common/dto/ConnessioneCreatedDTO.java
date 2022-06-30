package asw.edipogram.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnessioneCreatedDTO implements Serializable {

    private String utente;
    private String tipo;

}