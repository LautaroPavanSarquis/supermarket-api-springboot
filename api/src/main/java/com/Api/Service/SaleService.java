package com.Api.Service;

import com.Api.DTOs.SaleDetailDto;
import com.Api.DTOs.SaleDto;
import com.Api.Mappers.Mapper;
import com.Api.Model.Branch;
import com.Api.Model.Product;
import com.Api.Model.Sale;
import com.Api.Model.SaleDetail;
import com.Api.Repository.BranchRepository;
import com.Api.Repository.ProductRepository;
import com.Api.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService implements ISaleService {

    //Dependency Injection
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ProductRepository productRepository;

    //CRUD
    @Override
    public SaleDto CreateSale(SaleDto saleDto) {

        //Validations
        if(saleDto == null) throw new RuntimeException("SaleDto is null");
        if(saleDto.getBranchId() == null) throw new RuntimeException("BranchId is null");
        if(saleDto.getDetail() == null) throw new RuntimeException("Detail is null");

        //Get Branch
        Branch branch = branchRepository.findById(saleDto.getBranchId()).orElse(null);
        if(branch == null) throw new RuntimeException("Branch not found");

        //Sale Creation
        Sale sale = new Sale();
        sale.setDate(saleDto.getDate());
        sale.setState(saleDto.getState());
        sale.setBranch(branch);
        sale.setTotal(saleDto.getTotal());

        //Sale detail Creation
        List<SaleDetail> saleDetails = new ArrayList<>();
        Double calculatedTotal = 0.0;

        // Product names assumed to be unique
        for(SaleDetailDto detailDto : saleDto.getDetail()){
            Product product = productRepository.findByName(detailDto.getProductName())
                    .orElse(null);

            if(product == null) throw new RuntimeException("Product not found");

            SaleDetail saleDetail = new SaleDetail();
            saleDetail.setProd(product);
            saleDetail.setPrice(detailDto.getPrice());
            saleDetail.setProductQuantity(detailDto.getProductQuantity());
            saleDetail.setSale(sale);

            saleDetails.add(saleDetail);
        }

        sale.setDetail(saleDetails);

        saleRepository.save(sale);

        return Mapper.toDto(sale);
    }

    //Search
    //Get all
    @Override
    public List<SaleDto> getSales() {
        List<Sale> Sales = saleRepository.findAll();
        List<SaleDto> saleDtos = new ArrayList<>();

        SaleDto dto = new SaleDto();

        for (Sale sale : Sales) {
            dto = Mapper.toDto(sale);
            saleDtos.add(dto);
        }

        return saleDtos;
    }

    @Override
    public SaleDto UpdateSale(Long id, SaleDto saleDto) {
        //Find Sale
        Sale sale = saleRepository.findById(id).orElse(null);
        if(sale == null) throw new RuntimeException("Sale not found");

        if(saleDto.getDate()!= null){
            sale.setDate(saleDto.getDate());
        }

        if(saleDto.getState() != null){
            sale.setState(saleDto.getState());
        }

        if(saleDto.getTotal() != null){
            sale.setTotal(saleDto.getTotal());
        }

        if(saleDto.getBranchId() != null){
            sale.setBranch(branchRepository.findById(saleDto.getBranchId()).orElse(null));
            if (sale.getBranch() != null) {throw  new RuntimeException("Branch not found");}
        };

        saleRepository.save(sale);

        return Mapper.toDto(sale);
    }

    @Override
    public void DeleteSale(Long id) {

        saleRepository.deleteById(id);

    }
}
