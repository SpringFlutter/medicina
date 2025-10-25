package saitel.medicina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saitel.medicina.entity.RevisionOrganosSistemas;
import saitel.medicina.repository.RevisionOrganosSistemasRepository;

@Service
public class RevisionOrganosSistemasServiceImpLog implements RevisionOrganosSistemasService{
    @Autowired
    private RevisionOrganosSistemasRepository revisionOrganosSistemasRepository;

    @Override
    public RevisionOrganosSistemas guardarRevision(RevisionOrganosSistemas revision) {
        return revisionOrganosSistemasRepository.save(revision);
    }

    @Override
    public List<RevisionOrganosSistemas> findAll() {
        return revisionOrganosSistemasRepository.findAll();
    }

    @Override
    public Optional<RevisionOrganosSistemas> findById(Integer id) {
        return revisionOrganosSistemasRepository.findById(id);
    }

    @Override
    public RevisionOrganosSistemas updateRevision(Integer id, RevisionOrganosSistemas revisionOrganosSistemas) {
        if (revisionOrganosSistemasRepository.existsById(id)) {
            revisionOrganosSistemas.setIdRevision(id);
            return revisionOrganosSistemasRepository.save(revisionOrganosSistemas);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        revisionOrganosSistemasRepository.deleteById(id);
    }
}
