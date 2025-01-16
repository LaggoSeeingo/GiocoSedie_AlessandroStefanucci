/**
     * @author Alessandro Stefanucci
     * @version 16/01/2025
     * 
     */

class Partecipante extends Thread

{
	Posto sedie[];

	public Partecipante(Posto sedie[]) {

		this.sedie = sedie;

	}

        @Override
        /**
        * Gestisce l'esecuzione del singolo thread, verificando tramite i metodi "occupa()" e "libero()" della classe Posto, inoltre richiama il metodo "scrivi()" della classe Scrittore
        *
        */
        
	public void run() {

		try {
			sleep((int) (Math.random() * 1000));

			for (int i = 0; i < sedie.length; i++) {
				if (sedie[i].occupa()) {
					System.out.println("Sono il Thread " + this.getName()
							+ ". Sono riuscito a sedermi sul posto " + i);
                                        
                                        Scrittore scrittore = new Scrittore("Risultato.txt", "Posto " + i + " occupato dal thread di nome: " + this.getName() + " e con id: " + this.getId());

                                        scrittore.scrivi();
					return;
				}
			}
			System.out.println("Sono il Thread " + this.getName()
					+ ". Ho perso :((((");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

        
}