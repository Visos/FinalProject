package com.betacom.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.Prodotto;

@Repository
public interface IProdottoRepository extends JpaRepository<Prodotto, Integer> {

	@Query("SELECT p FROM Prodotto p " +
		       "WHERE (:id IS NULL OR p.id = :id) AND " +
		       "(:sesso IS NULL OR p.sesso = :sesso) AND " +
		       "(:colore IS NULL OR p.colore.desc = :colore) AND " +
		       "(:marca IS NULL OR p.marca.desc = :marca) AND " +
		       "(:materiale IS NULL OR p.materiale.desc = :materiale) AND " +
		       "(:fantasia IS NULL OR p.fantasia.desc = :fantasia) AND " +
		       "(:idMaglietta IS NULL OR p.maglietta.id = :idMaglietta) AND " +
		       "(:idPantalone IS NULL OR p.pantalone.id = :idPantalone) AND " +
		       "(:idVestito IS NULL OR p.vestito.id = :idVestito) AND " +
		       "(:idScarpa IS NULL OR p.scarpa.id = :idScarpa) AND " +
		       "(:idCamicia IS NULL OR p.camicia.id = :idCamicia) AND " +
		       "(:prezzo IS NULL OR p.prezzo = :prezzo)"
		)
	List<Prodotto> findByParam(
			@Param("id") Integer id,
			@Param("sesso") String sesso,
			@Param("colore") String colore,
			@Param("marca") String marca,
			@Param("materiale") String materiale,
			@Param("fantasia") String fantasia,
			@Param("idMaglietta") Integer idMaglietta,
			@Param("idPantalone") Integer idPantalone,
			@Param("idVestito") Integer idVestito,
			@Param("idScarpa") Integer idScarpa,
			@Param("idCamicia") Integer idCamicia,
			@Param("prezzo") Double prezzo			
);
	
	@Query("SELECT p FROM Prodotto p " +
				"INNER JOIN Maglietta m on p.maglietta.id = m.id " +
		       "WHERE (:id IS NULL OR p.id = :id) AND " +
		       "(:sesso IS NULL OR p.sesso = :sesso) AND " +
		       "(:colore IS NULL OR p.colore.desc = :colore) AND " +
		       "(:marca IS NULL OR p.marca.desc = :marca) AND " +
		       "(:materiale IS NULL OR p.materiale.desc = :materiale) AND " +
		       "(:fantasia IS NULL OR p.fantasia.desc = :fantasia) AND " +
		       "(:idMaglietta IS NULL OR p.maglietta.id = :idMaglietta) AND " +
		       "(:prezzo IS NULL OR p.prezzo = :prezzo) AND " +
		       "(:vestibilita IS NULL OR m.vestibilita.desc = :vestibilita) AND " + 
		       "(:taglia IS NULL OR m.taglia.desc = :taglia) AND " + 
		       "(:lunghezzaManica IS NULL OR m.lunghezzaManica.desc = :lunghezzaManica) AND " + 
		       "(:tipoColletto IS NULL OR m.tipoColletto.desc = :tipoColletto)"    
		)
	List<Prodotto> findMagliettaByParam(
			@Param("id") Integer id,
			@Param("sesso") String sesso,
			@Param("colore") String colore,
			@Param("marca") String marca,
			@Param("materiale") String materiale,
			@Param("fantasia") String fantasia,
			@Param("idMaglietta") Integer idMaglietta,
			@Param("prezzo") Double prezzo,
			@Param("taglia") String taglia,
			@Param("vestibilita") String vestibilita,
			@Param("lunghezzaManica") String lunghezzaManica,
			@Param("tipoColletto") String tipoColletto
);
	
	@Query("SELECT p FROM Prodotto p " +
			"INNER JOIN Pantalone m on p.pantalone.id = m.id " +
	       "WHERE (:id IS NULL OR p.id = :id) AND " +
	       "(:sesso IS NULL OR p.sesso = :sesso) AND " +
	       "(:colore IS NULL OR p.colore.desc = :colore) AND " +
	       "(:marca IS NULL OR p.marca.desc = :marca) AND " +
	       "(:materiale IS NULL OR p.materiale.desc = :materiale) AND " +
	       "(:fantasia IS NULL OR p.fantasia.desc = :fantasia) AND " +
	       "(:idMaglietta IS NULL OR p.pantalone.id = :idPantalone) AND " +
	       "(:prezzo IS NULL OR p.prezzo = :prezzo) AND " +
	       "(:vestibilita IS NULL OR m.vestibilita.desc = :vestibilita) AND " + 
	       "(:taglia IS NULL OR m.taglia.desc = :taglia) AND " + 
	       "(:lunghezza IS NULL OR m.lunghezza.desc = :lunghezza)"	       
	)
List<Prodotto> findPantaloneByParam(
		@Param("id") Integer id,
		@Param("sesso") String sesso,
		@Param("colore") String colore,
		@Param("marca") String marca,
		@Param("materiale") String materiale,
		@Param("fantasia") String fantasia,
		@Param("idPantalone") Integer idPantalone,
		@Param("prezzo") Double prezzo,
		@Param("taglia") String taglia,
		@Param("vestibilita") String vestibilita,
		@Param("lunghezza") String lunghezza
);
	
	@Query("SELECT p FROM Prodotto p " +
			"INNER JOIN Vestito m on p.vestito.id = m.id " +
	       "WHERE (:id IS NULL OR p.id = :id) AND " +
	       "(:sesso IS NULL OR p.sesso = :sesso) AND " +
	       "(:colore IS NULL OR p.colore.desc = :colore) AND " +
	       "(:marca IS NULL OR p.marca.desc = :marca) AND " +
	       "(:materiale IS NULL OR p.materiale.desc = :materiale) AND " +
	       "(:fantasia IS NULL OR p.fantasia.desc = :fantasia) AND " +
	       "(:idMaglietta IS NULL OR p.vestito.id = :idVestito) AND " +
	       "(:prezzo IS NULL OR p.prezzo = :prezzo) AND " +
	       "(:vestibilita IS NULL OR m.vestibilita = :vestibilita) AND " + 
	       "(:taglia IS NULL OR m.taglia.desc = :taglia) AND " + 
	       "(:lunghezza IS NULL OR m.lunghezza.desc = :lunghezza) AND " + 
	       "(:lunghezzaManica IS NULL OR m.lunghezzaManica.desc = :lunghezzaManica)"
	)
List<Prodotto> findVestitoByParam(
		@Param("id") Integer id,
		@Param("sesso") String sesso,
		@Param("colore") String colore,
		@Param("marca") String marca,
		@Param("materiale") String materiale,
		@Param("fantasia") String fantasia,
		@Param("idVestito") Integer idVestito,
		@Param("prezzo") Double prezzo,
		@Param("taglia") String taglia,
		@Param("vestibilita") String vestibilita,
		@Param("lunghezza") String lunghezza,
		@Param("lunghezzaManica") String lunghezzaManica
		
);
	
	@Query("SELECT p FROM Prodotto p " +
			"INNER JOIN Camicia m on p.camicia.id = m.id " +
	       "WHERE (:id IS NULL OR p.id = :id) AND " +
	       "(:sesso IS NULL OR p.sesso = :sesso) AND " +
	       "(:colore IS NULL OR p.colore.desc = :colore) AND " +
	       "(:marca IS NULL OR p.marca.desc = :marca) AND " +
	       "(:materiale IS NULL OR p.materiale.desc = :materiale) AND " +
	       "(:fantasia IS NULL OR p.fantasia.desc = :fantasia) AND " +
	       "(:idMaglietta IS NULL OR p.camicia.id = :idCamicia) AND " +
	       "(:prezzo IS NULL OR p.prezzo = :prezzo) AND " +
	       "(:vestibilita IS NULL OR m.vestibilita.desc = :vestibilita) AND " + 
	       "(:taglia IS NULL OR m.taglia.desc = :taglia) AND " + 
	       "(:lunghezza IS NULL OR m.lunghezzaManica.desc = :lunghezzaManica) AND " + 
	       "(:lunghezzaManica IS NULL OR m.tipoColletto.desc = :tipoColletto)"
	)
List<Prodotto> findCamiciaByParam(
		@Param("id") Integer id,
		@Param("sesso") String sesso,
		@Param("colore") String colore,
		@Param("marca") String marca,
		@Param("materiale") String materiale,
		@Param("fantasia") String fantasia,
		@Param("idCamicia") Integer idCamicia,
		@Param("prezzo") Double prezzo,
		@Param("taglia") String taglia,
		@Param("vestibilita") String vestibilita,
		@Param("lunghezzaManica") String lunghezzaManica,
		@Param("tipoColletto") String tipoColletto
		
);
	
	@Query("SELECT p FROM Prodotto p " +
			"INNER JOIN Scarpa m on p.scarpa.id = m.id " +
	       "WHERE (:id IS NULL OR p.id = :id) AND " +
	       "(:sesso IS NULL OR p.sesso = :sesso) AND " +
	       "(:colore IS NULL OR p.colore.desc = :colore) AND " +
	       "(:marca IS NULL OR p.marca.desc = :marca) AND " +
	       "(:materiale IS NULL OR p.materiale.desc = :materiale) AND " +
	       "(:fantasia IS NULL OR p.fantasia.desc = :fantasia) AND " +
	       "(:idMaglietta IS NULL OR p.scarpa.id = :idScarpa) AND " +
	       "(:prezzo IS NULL OR p.prezzo = :prezzo) AND " +
	       "(:vestibilita IS NULL OR m.tagliaScarpe = :tagliaScarpe) AND " + 
	       "(:taglia IS NULL OR m.chiusura.desc = :chiusura) AND " + 
	       "(:lunghezza IS NULL OR m.tipoScarpa = :tipoScarpa) "
	)
List<Prodotto> findScarpaByParam(
		@Param("id") Integer id,
		@Param("sesso") String sesso,
		@Param("colore") String colore,
		@Param("marca") String marca,
		@Param("materiale") String materiale,
		@Param("fantasia") String fantasia,
		@Param("idScarpa") Integer idScarpa,
		@Param("prezzo") Double prezzo,
		@Param("tagliaScarpe") Integer tagliaScarpe,
		@Param("chiusura") String chiusura,
		@Param("tipoScarpa") String tipoScarpa		
);


	
	
	
}
