import java.io.PrintStream;
import java.util.List;
import java.util.ArrayList;

import static java.util.stream.Collectors.*;

public final class Lac {
    private final int energieSolaire;
    private final List<Plante> plantes;

    public Lac(int energieSolaire, List<Plante> plantes) {
        this.energieSolaire = energieSolaire;
        this.plantes = plantes;
    }

    /**
     * Avance la simulation d'un cycle.
     */
    public void tick() {
        List<Plante> plantesProchainCycle = new ArrayList<>();
        double ratioEnergie = this.energieSolaire / energiePlantes();

        for (Plante plante : plantes) {
            int nbEnfants = plante.vivreCycle(ratioEnergie);
            while(nbEnfants > 0){
                Plante nouvelEnfant = new Plante(plante.getNomEspece(),
                        plante.getBesoinEnergie(),
                        plante.getEfficaciteEnergie(),
                        plante.getResilience(),
                        plante.getFertilite(),
                        plante.getAgeFertilite(),
                        plante.getEnergieEnfant());
                plantesProchainCycle.add(nouvelEnfant);
                nbEnfants--;
            }
        }
    }

    public double energiePlantes(){
        double energiePlantes = 0;
        for(Plante plante: plantes){
            energiePlantes += plante.getEnergie();
        }
        return energiePlantes;
    }


    public void imprimeRapport(PrintStream out) {
        var especes = this.plantes.stream().collect(groupingBy(
                Plante::getNomEspece,
                summarizingDouble(Plante::getEnergie)));
        out.println("Il reste " + especes.size() + " espèces de plantes.");
        for (var entry : especes.entrySet()) {
            var value = entry.getValue();
            out.println(entry.getKey() + ": " +
                    value.getCount() + " individus qui contiennent en tout " +
                    value.getSum() + " unités d'énergie.");
        }
    }
}
