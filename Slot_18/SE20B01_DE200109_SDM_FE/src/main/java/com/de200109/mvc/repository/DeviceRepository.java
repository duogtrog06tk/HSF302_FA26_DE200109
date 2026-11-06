package com.de200109.mvc.repository;

import com.de200109.mvc.entity.Category;
import com.de200109.mvc.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

    List<Device> findAllByOrderByInstallationDateDesc();

    List<Device> findByDeviceNameContainingIgnoreCaseOrderByInstallationDateDesc(String deviceName);

    Optional<Device> findByDeviceCode(String deviceCode);
}
