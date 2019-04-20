package br.ufsc.ppgcc.experion.view.profile.builder.engine;

import br.ufsc.ppgcc.experion.view.expertise.Expertise;
import br.ufsc.ppgcc.experion.view.profile.Profile;

import java.util.Set;

/**
 * The interface a class that wants to act as an ProfileBuilderEngine must implement
 *
 * @author Rodrigo Gonçalves
 * @version 2019-03-05 - First version
 *
 */
public interface ProfileBuilderEngine {
    Set<Profile> buildProfiles(Set<Expertise> expertise);
}
