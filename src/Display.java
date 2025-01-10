/**
     * @author Alessandro Stefanucci
     */

class Display extends Thread

{
	private Posto sedie[]; // sedie array che contiene i posti occupabili dai partecipanti
	private boolean endgame; //valore booleano utile a capire se lo stato di tutte le celle dell'array sedie[] sono stati stampati
        
        /**
         * 
         * @param sedie numero massimo di posti, pari al numero di partecipanti -1
         */
        
	public Display(Posto sedie[]) {

		this.sedie = new Posto[sedie.length];

		for (int s = 0; s < sedie.length; s++)
			this.sedie[s] = sedie[s];
	}

	public void run() {

		try {
			while (!endgame) {
				int count = 0;

				sleep((int) (Math.random() * 250));

				for (int i = 0; i < sedie.length; i++) {
				
					if (sedie[i].libero())
						System.out.print("0");
					else {
						count++;
						System.out.print("*");
					}
				}
				System.out.println();
				endgame = (count == sedie.length);
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
