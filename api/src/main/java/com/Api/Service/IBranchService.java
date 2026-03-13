package com.Api.Service;



import com.Api.DTOs.BranchDto;

import java.util.List;

public interface IBranchService  {

    //CRUD
    //Create
    BranchDto CreateBranch(BranchDto BranchDto);

    //Read
    List<BranchDto> getBranches();

    //Update
    BranchDto UpdateBranch(Long id, BranchDto BranchDto);

    //Delete
    void DeleteBranch(Long id);

}
