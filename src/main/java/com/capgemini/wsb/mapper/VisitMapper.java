package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.stream.Collectors;

public class VisitMapper {

    public static VisitTO mapToTO(VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }
        VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());
        visitTO.setDoctor(DoctorMapper.mapToTO(visitEntity.getDoctor()));
        visitTO.setPatient(PatientMapper.mapToTO(visitEntity.getPatient()));
        visitTO.setMedicalTreatments(visitEntity.getMedicalTreatments().stream()
                .map(MedicalTreatmentMapper::mapToTO)
                .collect(Collectors.toList()));
        return visitTO;
    }

    public static VisitEntity mapToEntity(VisitTO visitTO) {
        if (visitTO == null) {
            return null;
        }
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());
        visitEntity.setDoctor(DoctorMapper.mapToEntity(visitTO.getDoctor()));
        visitEntity.setPatient(PatientMapper.mapToEntity(visitTO.getPatient()));
        visitEntity.setMedicalTreatments(visitTO.getMedicalTreatments().stream()
                .map(MedicalTreatmentMapper::mapToEntity)
                .collect(Collectors.toList()));
        return visitEntity;
    }
}
