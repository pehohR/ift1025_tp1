public class UsinePlante {
    protected String nomEspece;
    protected double besoinEnergie;
    protected double efficaciteEnergie;
    protected double resilience;
    protected double fertilite;
    protected int ageFertilite;
    protected double energieEnfant;
    private static final int nbAttributs = 7;
    private final boolean[] attributsInitialises ;

    // Constructeur
    public UsinePlante(){
        this.attributsInitialises = new boolean[nbAttributs];
    }

    // Setters
    public void setNomEspece(String nomEspece){
        if (nomEspece.length() > 0){
            this.nomEspece = nomEspece;
            this.attributsInitialises[0] = true;
        }
    }
    public void setBesoinEnergie(double besoinEnergie){
        if (besoinEnergie > 0){
            this.besoinEnergie = besoinEnergie;
            this.attributsInitialises[1] = true;
        }
    }
    public void setEfficaciteEnergie(double efficaciteEnergie) {
        if (efficaciteEnergie >= 0 && efficaciteEnergie <= 1) {
            this.efficaciteEnergie = efficaciteEnergie;
            this.attributsInitialises[2] = true;
        }
    }
    public void setResilience(double resilience) {
        if (resilience >= 0 && resilience <= 1) {
            this.resilience = resilience;
            this.attributsInitialises[3] = true;
        }
    }
    public void setFertilite(double fertilite) {
        if (fertilite >= 0 && fertilite <= 1) {
            this.fertilite = fertilite;
            this.attributsInitialises[4] = true;
        }
    }
    public void setAgeFertilite(int ageFertilite) {
        if (ageFertilite >= 0){
            this.ageFertilite = ageFertilite;
            this.attributsInitialises[5] = true;
        }

    }
    public void setEnergieEnfant(double energieEnfant) {
        if (energieEnfant > 0){
            this.energieEnfant = energieEnfant;
            this.attributsInitialises[6] = true;
        }
    }

    public Plante creerPlante() throws ConditionsInitialesInvalides {
        for (boolean bool : attributsInitialises) {
            if (!bool) {
                throw new ConditionsInitialesInvalides("Au moins un des " +
                "attributs nécessaires à la création d'une plante est manquant.");
            }
        }
        Plante plante = new Plante();
        plante.nomEspece = this.nomEspece;
        plante.energie = this.energieEnfant;
        plante.age = 0;
        plante.besoinEnergie = this.besoinEnergie;
        plante.efficaciteEnergie = this.efficaciteEnergie;
        plante.resilience = this.resilience;
        plante.fertilite = this.fertilite;
        plante.ageFertilite = this.ageFertilite;
        plante.energieEnfant = this.energieEnfant;
        return plante;
    }
}
