package it.exolab.aero.airport_01Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EntryDataDto implements Serializable {
    private static final long serialVersionUID = 7618096602167304404L;

    private int mese;
    private int anno;


}
