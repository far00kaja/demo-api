package com.domain.controllers;

import java.util.List;

import javax.validation.Valid;

import com.domain.dto.ResponseData;
import com.domain.dto.SearchData;
import com.domain.dto.SupplierData;
import com.domain.models.entities.Supplier;
import com.domain.services.SupplierService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/suppliers")
public class SupplierController {
    
    @Autowired
    private SupplierService supplierService;
    
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Supplier>> create(@Valid @RequestBody SupplierData supplierData, Errors Errors){
        ResponseData<Supplier> responseData = new ResponseData<>();

        if (Errors.hasErrors()){
            for(ObjectError error: Errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        //sebelum modelMapper
        // Supplier supplier =  new Supplier();
        // supplier.setName(supplierData.getName());
        // supplier.setAddress(supplierData.getAddress());
        // supplier.setEmail(supplierData.getEmail());

        //sesudah pakai modelMapper
        Supplier supplier = modelMapper.map(supplierData, Supplier.class);
        responseData.setStatus(true);
        responseData.setPayload(supplierService.save(supplier));
        return ResponseEntity.ok(responseData);

    }

    @GetMapping
    public Iterable<Supplier> findAll(){
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public Supplier findOne(Long id){
        return supplierService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Supplier>> update(@Valid @RequestBody SupplierData supplierData, Errors Errors){
        ResponseData<Supplier> responseData = new ResponseData<>();

        if (Errors.hasErrors()){
            for(ObjectError error: Errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Supplier supplier = modelMapper.map(supplierData, Supplier.class);
        responseData.setStatus(true);
        responseData.setPayload(supplierService.save(supplier));
        return ResponseEntity.ok(responseData);

    }

    @PostMapping("search/byemail")
    public Supplier findByEmail(@RequestBody SearchData searchData){
        return supplierService.findByEmail(searchData.getSearchKey());
    }

    @PostMapping("search/byname")
    public List<Supplier> findByName(@RequestBody SearchData searchData){
        return supplierService.findByName(searchData.getSearchKey());
    }

    @PostMapping("search/bynamestartwith")
    public List<Supplier> findByNameStartWith(@RequestBody SearchData searchData){
        return supplierService.findByNameStartingWith(searchData.getSearchKey());
    }

    @PostMapping("search/bynameoremail")
    public List<Supplier> findByNameOrEmail(@RequestBody SearchData searchData){
        return supplierService.findByNameOrEmail(searchData.getSearchKey(),searchData.getOtherSearchKey());
    }

}
