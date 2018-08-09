package com.cg.newpro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.newpro.beans.Customer;

@Repository
public interface WalletRepo extends JpaRepository<Customer, String> {

}
