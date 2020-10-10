package testTransport.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
@Data
public class Transport {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  String name;

  Double price;

  TypeTransport typeTransport;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  LocalDate dateAdd;

  public void setTypeTransport(String type) {
    this.typeTransport = Arrays.stream(TypeTransport.values()).
            filter(i -> i.getTitle().equals(type))
            .findFirst()
            .orElseThrow(EntityNotFoundException::new);
  }

  public String getTypeTransport() {
    return typeTransport.getTitle();
  }
}
