package com.synectiks.asset.service;

import com.synectiks.asset.domain.Organization;
import com.synectiks.asset.repository.OrganizationRepository;
import com.synectiks.asset.util.JsonAndObjectConverterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrganizationService.class);

    @Autowired
    private OrganizationRepository organizationRepository;

	@Autowired
	private JsonAndObjectConverterUtil jsonAndObjectConverterUtil;

    public Organization save(Organization organization) {
    	logger.debug("Save Organization : {}", organization);
        return organizationRepository.save(organization);
    }



    @Transactional(readOnly = true)
    public List<Organization> findAll(){
    	logger.debug("Get all Organizations");
    	List<Organization> list = organizationRepository.findAll();
//    	Map<String, String> filter = new HashMap<>();
//    	for(Organization o: list) {
//    		filter.clear();
//    		for(Department d: o.getDepartments()) {
//    			filter.clear();
//    			filter.put("departmentId", String.valueOf(d.getId()));
//    			d.setProducts(serviceAllocationService.getProducts(filter));
//    		}
//    	}
    	return list;
    }

    @Transactional(readOnly = true)
    public Optional<Organization> findOne(Long id) {
    	logger.debug("Get Organization : {}", id);
    	Optional<Organization> o = organizationRepository.findById(id);
    	return o;
    }

    public void delete(Long id) {
    	logger.debug("Request to delete Organization : {}", id);
        organizationRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Organization> search(Organization organization) {
    	logger.debug("Search organizations on given filters");
//    	String landingZone = null;
//    	if (!StringUtils.isBlank(filter.get(Constants.LANDING_ZONE))) {
//    		landingZone = filter.get(Constants.LANDING_ZONE);
//			filter.remove(Constants.LANDING_ZONE);
//		}
//
//        Organization organization = jsonAndObjectConverterUtil.convertSourceObjectToTarget(Constants.instantiateMapper(), filter, Organization.class);
//
//        //unset default value if createdOn is not coming in filter
//        if(StringUtils.isBlank(filter.get(Constants.CREATED_ON))){
//            organization.setCreatedOn(null);
//        }
//        //unset default value if updatedOn is not coming in filter
//        if(StringUtils.isBlank(filter.get(Constants.UPDATED_ON))){
//            organization.setUpdatedOn(null);
//        }
        List<Organization> list = organizationRepository.findAll(Example.of(organization), Sort.by(Sort.Direction.DESC, "name"));
//        Map<String, String> prdfilter = new HashMap<>();
//    	for(Organization o: list) {
//    		filter.clear();
//    		for(Department d: o.getDepartments()) {
//    			prdfilter.clear();
//    			prdfilter.put("departmentId", String.valueOf(d.getId()));
//    			if(!StringUtils.isBlank(landingZone)) {
//    				prdfilter.put("landingZone", landingZone);
//    			}
//    			d.setProducts(serviceAllocationService.getProducts(prdfilter));
//    		}
//    	}
    	return list;
    }
    
    
    
    public List<String> getProducts(Long orgId) throws IOException {
    	logger.debug("Request to get list of products of an Organization");
    	return organizationRepository.getProduct(orgId);
    }
    
    public List<String> getDepartmentProducts(Long orgId, Long depId) throws IOException {
    	logger.debug("Request to get list of products of an Organization");
    	return organizationRepository.getDepartmentProduct(orgId,depId);
    }
//    associated landing Zones
    public List<String> getLandingZones(Long orgId) throws IOException {
    	logger.debug("Request to get list of landing zone of an Organization");
    	return organizationRepository.getLandingZone(orgId);
    }
    
    public List<String> getDepartmentLandingZones(Long orgId, Long depId ) throws IOException {
    	logger.debug("Request to get list of landing zone of an Department an Organization");
    	return organizationRepository.getDepartmentLandingZones(orgId,depId);
    }
    public List<String> getCloudnameLandingZones(Long orgId,String cloudName) throws IOException {
    	logger.debug("Request to get list of landing zone of cloudName an Organization");
    	return organizationRepository.getCloudnameLandingZones(orgId,cloudName);
    }
    public List<String> getDepartmentCloudnameLandingZones(Long orgId, Long depId, String cloudName) throws IOException {
    	logger.debug("Request to get list of landing zone of cloudName an Department an Organization");
    	return organizationRepository.getDepartmentCloudnameLandingZones(orgId,depId,cloudName);
    }
    
    //product enclaves
   
    public List<String> getOrganizationProductEnclave(Long orgId) throws IOException {
    	logger.debug("Request to get list of product enclaves of an Organization");
    	return organizationRepository.getOrganizationProductEnclave(orgId);
    }
    public List<String> getOrganizationDepartmentsProductEnclave(Long orgId, Long depId ) throws IOException {
    	logger.debug("Request to get list of product enclaves of an Department an Organization");
    	return organizationRepository.getOrganizationDepartmentsProductEnclave(orgId,depId);
    }
    public List<String> getOrganizationLandingzoneProductEnclave(Long orgId,String landingZone) throws IOException {
    	logger.debug("Request to get list of product enclaves of landingZoneName an Organization");
    	return organizationRepository.getObj(orgId,landingZone);
    }
    public List<String> getOrganizationDepartmentLandingzoneProductEnclave(Long orgId, Long depId, String landingZone) throws IOException {
    	logger.debug("Request to get list of product enclaves of landingZoneName an Department an Organization");
    	return organizationRepository.getOrganizationDepartmentLandingzoneProductEnclave(orgId,depId,landingZone);
    }
    
}