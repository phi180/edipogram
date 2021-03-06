package asw.edipogram.common.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateConnessioneRequest implements Serializable {

    private String utente;
    private String tipo;

}