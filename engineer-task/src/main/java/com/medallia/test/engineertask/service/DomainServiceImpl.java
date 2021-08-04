package com.medallia.test.engineertask.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.medallia.test.engineertask.model.Domain;
import com.medallia.test.engineertask.model.Image;
import com.medallia.test.engineertask.repository.DomainRepository;
import com.medallia.test.engineertask.repository.ImageRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DomainServiceImpl implements DomainService {

	private DomainRepository domainRepository;
	private ImageRepository imageRepository;
	
	public DomainServiceImpl(DomainRepository domainRepository, ImageRepository imageRepository) {
        this.domainRepository = domainRepository;
        this.imageRepository = imageRepository;
    }
	
	@Override
	public List<Domain> findAll() {
		List<Domain> domains = new ArrayList<>();
		domainRepository.findAll().forEach(domains::add);
        return domains;
	}

	@Override
	public Domain save(Domain domain) {
		
		log.info("DomainServiceImpl > save - START");
		
		// Here we should have a try catch, If we have an error a rollback should be done - For transactional data
		
		List<Image> imagesAux = new ArrayList<Image>();
		Domain SavingDomain;
		
		if (domain.getImages() != null && !domain.getImages().isEmpty())
			imagesAux.addAll(domain.getImages());
		
		
		
		/* If the Domain haven't ID we need to save it before save the images */
		if (domain.getDomainId() == null) {
				
			/* Save the domain with required values */
			SavingDomain = new Domain(domain.getDomain());
			
			/* Set the images to saved domain */
			SavingDomain = domainRepository.save(SavingDomain);
			
		}
		else {
			
			SavingDomain = domain;
		}
		
		if (imagesAux != null && !imagesAux.isEmpty()) {
			
			for (Image image : imagesAux) {
				image.setDomain(SavingDomain);
			}
			
			imageRepository.saveAll(imagesAux);
			
		}
		
		if(domain.getDomainId() != null)
			SavingDomain = domainRepository.save(domain);
		
		return SavingDomain;
	}

	@Override
	public Domain findById(Long id) {
		 return domainRepository.findById(id).get();
	}

	@Override
	public void delete(Domain domain) {
		domainRepository.delete(domain);

	}
	

}
