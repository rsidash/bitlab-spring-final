package kz.bitlab.academy.finalsprint.folders.repository;

import kz.bitlab.academy.finalsprint.folders.entity.FolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<FolderEntity, Long> {

    boolean existsByName(String name);

}
