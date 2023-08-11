package com.synectiks.asset.controller;

import com.synectiks.asset.api.controller.LandingzoneApi;
import com.synectiks.asset.api.model.LandingzoneDTO;
import com.synectiks.asset.domain.Landingzone;
import com.synectiks.asset.mapper.LandingzoneMapper;
import com.synectiks.asset.repository.LandingzoneRepository;
import com.synectiks.asset.service.LandingzoneService;
import com.synectiks.asset.web.rest.validation.Validator;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LandingzoneController implements LandingzoneApi {

	private final Logger logger = LoggerFactory.getLogger(LandingzoneController.class);

	private static final String ENTITY_NAME = "Landingzone";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    @Autowired
    private LandingzoneService landingzoneService;

    @Autowired
    private LandingzoneRepository landingzoneRepository;

    @Autowired
    private Validator validator;

    @Override
    public ResponseEntity<LandingzoneDTO> getLandingzone(Long id) {
        logger.debug("REST request to get a landing-zone : ID: {}", id);
        Optional<Landingzone> oObj = landingzoneService.findOne(id);
        LandingzoneDTO LandingzoneDTO = LandingzoneMapper.INSTANCE.entityToDto(oObj.orElse(null));
        return ResponseUtil.wrapOrNotFound(Optional.of(LandingzoneDTO));
    }

    @Override
    public ResponseEntity<List<LandingzoneDTO>> getLandingzoneList(){
        logger.debug("REST request to get all landing-zones");
        List<Landingzone> landingzoneList = landingzoneService.findAll();
        List<LandingzoneDTO> landingzoneDTOList = LandingzoneMapper.INSTANCE.entityToDtoList(landingzoneList);
        return ResponseEntity.ok(landingzoneDTOList);
    }

    @Override
    public ResponseEntity<LandingzoneDTO> addLandingzone(LandingzoneDTO landingzoneDTO){
        logger.debug("REST request to add a landing-zone : {}", landingzoneDTO);
        validator.validateNotNull(landingzoneDTO.getId(), ENTITY_NAME);
        Landingzone landingzone = LandingzoneMapper.INSTANCE.dtoToEntity(landingzoneDTO);
        landingzone = landingzoneService.save(landingzone);
        LandingzoneDTO result = LandingzoneMapper.INSTANCE.entityToDto(landingzone);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<LandingzoneDTO> updateLandingzone(LandingzoneDTO landingzoneDTO) {
        logger.debug("REST request to update a landing-zone : {}", landingzoneDTO);
        validator.validateNull(landingzoneDTO.getId(), ENTITY_NAME);
        validator.validateEntityExistsInDb(landingzoneDTO.getId(), ENTITY_NAME, landingzoneRepository);
        Landingzone existingLandingzone = landingzoneRepository.findById(landingzoneDTO.getId()).get();
        Landingzone tempLandingzone = LandingzoneMapper.INSTANCE.dtoToEntityForUpdate(landingzoneDTO, existingLandingzone);
        Landingzone landingzone = landingzoneService.save(tempLandingzone);
        LandingzoneDTO result = LandingzoneMapper.INSTANCE.entityToDto(landingzone);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<LandingzoneDTO>> searchLandingzone(LandingzoneDTO landingzoneDTO) {
        Landingzone landingzone = LandingzoneMapper.INSTANCE.dtoToEntityForSearch(landingzoneDTO);
        logger.debug("REST request to get all landing-zones on given filters : {} ", landingzone);
        List<Landingzone> landingzoneList = landingzoneService.search(landingzone);
        List<LandingzoneDTO> landingzoneDTOList = LandingzoneMapper.INSTANCE.entityToDtoList(landingzoneList);
        return ResponseEntity.ok(landingzoneDTOList);
    }


    
}