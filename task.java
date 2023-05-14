import java.util.ArrayList;

public enum task {
   //tareas del hogar
   Limpiar_ventanas, recoger_la_habitación, limpiar_el_techo, limpiar_el_suelo, Operar_el_riñon, Baile_una_jota, Salto_en_barra, Juega_al_tenis, Juega_al_ping_pong, Juega_al_futbol, Juega_al_baloncesto, Juega_al_voleibol, Juega_al_beisbol, Juega_al_rugby, Juega_al_hockey, Juega_al_golf, Juega_al_billar, Juega_al_poker, Juega_al_blackjack, Juega_al_solitario, Juega_al_truco, Juega_al_tute, Juega_al_mus, Juega_al_chinchon, Juega_al_parchis, Juega_al_damas, Juega_al_ajedrez, Juega_al_estratego, Juega_al_risk, Juega_al_monopoly, Juega_al_cluedo, Juega_al_trivial, Juega_al_scrabble, Juega_al_ahorcado, Juega_al_3enraya, Juega_al_4enraya, Juega_al_7ymedio;

   public static ArrayList<String> getTareas() {
      ArrayList<String> tareas = new ArrayList<String>();
      for (task t : task.values()) {
         tareas.add(t.name());
      }
      return tareas;
   }
   public static String[] getcuatrotareas(){
      String[] tareas = new String[4];
      for (int i = 0; i < 4; i++) {
         int random = (int) (Math.random() * task.values().length);
         tareas[i]=task.values()[random].name();
      }
      return tareas;
   }
}