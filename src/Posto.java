/**
     * @author Alessandro Stefanucci
     * @version 16/01/2025
     * 
     */

class Posto

{
	private boolean occupato;

	public Posto()

	{
		occupato = false;
	}
        
             /**
     * Verifica se il posto è libero, viene usato nella classe Partecipante
     *
     */
	public synchronized boolean libero() {
		return (!occupato);
	}

        
        /**
     * Verifica se il posto è occupato, viene usato nella classe Partecipante
     *
     */
	public synchronized boolean occupa() {
		if (occupato)
			return false;
		else
			return occupato = true;
	}

        
}