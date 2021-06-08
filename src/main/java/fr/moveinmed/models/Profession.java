package fr.moveinmed.models;

public enum Profession {
    MEDECIN_GENARALISTE("Médecin généraliste"),
    CHIRURGIEN("Chirurgien,"),
    INFIRMIER("Infirmier"),
    KINESITHERAPEUTE("Kinésithérapeute"),
    ASSISTANTE_SOCIAL("Assistante sociale"),
    PSYCHOLOGUE("Psychologue");

    private String label;

    private Profession(String label) {
        this.label = label;
    }

    public static Profession getInstanceProfessionLibelle(String label) {
        Profession[] professions = Profession.values();
        for (Profession profession:
                professions) {
            if (profession.getLabel().equalsIgnoreCase(label)) {
                return profession;
            }
        }
        return null;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
