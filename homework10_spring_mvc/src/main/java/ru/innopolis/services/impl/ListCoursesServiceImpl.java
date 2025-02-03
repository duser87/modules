package ru.innopolis.services.impl;

import org.springframework.stereotype.Service;
import ru.innopolis.models.ListCourses;
import ru.innopolis.repositories.ListCoursesRepository;
import ru.innopolis.services.CRUDServiceInterface;

import java.util.List;

@Service
public class ListCoursesServiceImpl implements CRUDServiceInterface<ListCourses, String> {

    ListCoursesRepository listCoursesRepository;

    public ListCoursesServiceImpl(ListCoursesRepository repository){
        listCoursesRepository = repository;
    }

    @Override
    public ListCourses create(ListCourses list) throws Exception {
        return listCoursesRepository.create(list.getId(), list.getId_fio(), list.getId_course());
    }

    @Override
    public ListCourses update(ListCourses list) throws Exception {
        return listCoursesRepository.update(list.getId(), list.getId_fio(), list.getId_course());
    }

    @Override
    public String delete(Long id) {
        return listCoursesRepository.delete(id);
    }

    @Override
    public ListCourses findById(Long id) throws Exception {
        return listCoursesRepository.findById(id).orElseThrow();
    }

    public List<ListCourses> findListCourse(Long id_fio) throws Exception{
        return listCoursesRepository.findListById(id_fio);
    }

}
