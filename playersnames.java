import java.util.ArrayList;

public enum playersnames {
    //ejemplos nombres de jugadores
    Pedro, Ramon, Juan, Maria, Jose, Ana, Luis, Carlos, Alberto, Javier, Paula, Laura, Cristina;

    public static ArrayList<player> getPlayers() {
        ArrayList<player> jugadoresnombres = new ArrayList<player>();
        for (playersnames player : playersnames.values()) {
            player playero = new student(player.name());
            jugadoresnombres.add(playero);
        }
        return jugadoresnombres;
    }
}
