package com.BookProject.Repository;

import com.BookProject.Entity.Bk;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BkRepository extends JpaRepository<Bk, Long>{
//	List<Bk> findByBtitlContainingIgnoreCaseAndBwritContainingIgnoreCaseAndBpublContainingIgnoreCaseAndBsortContainingIgnoreCase(String btitl, String bwrit, String bpubl, String bsort);
//	List<Bk> findByBtitlContainingIgnoreCase(String btitl);
//	List<Bk> findByBwritContainingIgnoreCase(String bwrit);
//	List<Bk> findByBpublContainingIgnoreCase(String bpubl);
//	List<Bk> findByBsortContainingIgnoreCase(String bsort);
	@Query("select b from Bk b where (:btitl is null or lower(b.btitl) like lower(concat('%', :btitl, '%'))) and (:bwrit is null or lower(b.bwrit) like lower(concat('%', :bwrit, '%'))) and (:bpubl is null or lower(b.bpubl) like lower(concat('%', :bpubl, '%'))) and (:bsort is null or lower(b.bsort) like lower(concat('%', :bsort, '%')))")
	Page<Bk> findByMultipleCriteria(@Param("btitl") String btitl, @Param("bwrit") String bwrit, @Param("bpubl") String bpubl, @Param("bsort") String bsort, Pageable pageable);
}
