package pl.polsl.entities;

import javax.persistence.*;

@Entity
public class RegistryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String inputNumber;

    public String getInputNumber() {
        return inputNumber;
    }

    public void getInputNumber(String value) {
        inputNumber = value;
    }
    
    private String inputSystem;

    public String getInputSystem() {
        return inputSystem;
    }

    public void getInputSystem(String value) {
        inputSystem = value;
    }
    
    private String outputNumber;

    public String getOutputNumber() {
        return outputNumber;
    }

    public void getOutputNumber(String value) {
        outputNumber = value;
    }
    
    private String outputSystem;

    public String getOutputSystem() {
        return outputSystem;
    }

    public void getOutputSystem(String value) {
        outputSystem = value;
    }

    @OneToOne
    @JoinColumn(name = "dateentry_id", referencedColumnName = "id")
    private DateEntry dateEntry;

    public DateEntry getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(DateEntry value) {
        dateEntry = value;
    }

    public RegistryEntry(String inNumer,String inSystem,String outNumber,String outSystem, DateEntry date) {
        inputNumber = inNumer;
        inputSystem = inSystem;
        outputNumber = outNumber;
        outputSystem = outSystem;
        dateEntry = date;
    }

    public RegistryEntry() {

    }

    @Override
    public String toString() {
        return "RegistryEntry{" +
                "inputNumber='" + inputNumber + 
                ", inputSystem=" + inputSystem +
                ", outputNumber=" + outputNumber +
                ", outputSystem=" + outputSystem +
                ", date=" + dateEntry +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RegistryEntry)) {
            return false;
        }

        RegistryEntry other = (RegistryEntry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }

        return true;
    }
}