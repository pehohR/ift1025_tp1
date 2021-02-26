public final class Plante extends UsinePlante{
    protected int age;
    protected double energie;

    public Plante(){}

    public Plante(String nomEspece, double besoinEnergie, double efficaciteEnergie,
                  double resilience, double fertilite, int ageFertilite, double energieEnfant){
        this.nomEspece = nomEspece;
        this.energie=energieEnfant;
        this.age=0;
        this.besoinEnergie = besoinEnergie;
        this.efficaciteEnergie = efficaciteEnergie;
        this.resilience = resilience;
        this.fertilite = fertilite;
        this.ageFertilite = ageFertilite;
        this.energieEnfant = energieEnfant;
    }

    // Getters
    public String getNomEspece(){
        return this.nomEspece;
    }
    public double getEnergie(){
        return this.energie;
    }
    public int getAge() {
        return this.age;
    }
    public double getEfficaciteEnergie(){
        return this.efficaciteEnergie;
    }
    public double getBesoinEnergie(){
        return this.besoinEnergie;
    }
    public double getResilience(){
        return this.resilience;
    }
    public double getFertilite(){
        return this.fertilite;
    }
    public int getAgeFertilite(){
        return this.ageFertilite;
    }
    public double getEnergieEnfant() {
        return this.energieEnfant;
    }

    // Méthodes
    public int vivreCycle(double ratioEnergie){
        //TODO implémenter la méthode.
        int nbEnfants = 0;
        double energieAbsorbee = this.energie*ratioEnergie;
        this.survivre(energieAbsorbee);

        double energieSupplementaire = energieAbsorbee-this.energie;
        if (this.age >= this.ageFertilite){
            this.seReproduire(energieSupplementaire);
        }
        this.energie += energieSupplementaire*efficaciteEnergie;
        this.age ++;
        return nbEnfants;
    }

    public boolean survivre(double energieAbsorbee){
        if (energieAbsorbee > this.besoinEnergie){
            return true;
        }
        double energieManquante = this.besoinEnergie - energieAbsorbee;
        if (energieManquante > this.energie){
            this.energie = 0;
            return false;
            }
        double chanceDeSurvivre = Math.pow(this.resilience, energieManquante);
        if (chanceDeSurvivre >= Math.random()) {
                this.energie -= energieManquante;
                return true;
        }
        else {
            this.energie = 0;
            return false;
        }
    }

    public double seReproduire(double energieSupplementaire){
        int nbTentatives = (int) Math.floor(energieSupplementaire);
        while (nbTentatives > 0){
            //TODO à revoir!!
//            if (this.fertilite >= Math.random()){
//                //creer la nouvelle plante
//                if (energieSupplementaire >= this.energieEnfant){
//                    energieSupplementaire -= this.energieEnfant;
//                }
//                else {
//                    this.energie -= (this.energieEnfant - energieSupplementaire);
//                }
//
//            }
//            else {
            nbTentatives -= 1;
//            }
        }
        return energieSupplementaire;
    }
}
