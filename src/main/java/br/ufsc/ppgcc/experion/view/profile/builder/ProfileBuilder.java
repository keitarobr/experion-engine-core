package br.ufsc.ppgcc.experion.view.profile.builder;

import br.ufsc.ppgcc.experion.view.profile.builder.engine.ProfileBuilderEngine;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.lang.reflect.InvocationTargetException;

/**
 * A class that is responsible for registering a ProfileBuilderEngine to be used by the system. ProfileBuilder
 * takes a set of Expertise and generates a set of Profile.
 *
 * @author Rodrigo Gonçalves
 * @version 2019-03-05 - First Version
 *
 *
 */
@Entity
public class ProfileBuilder {

    /** Primary key - auto-generated by JPA */
    @Id
    @GeneratedValue
    private Integer id;

    /** The identifier (name) for this profile generator - usually in the form builderName */
    @Column(unique=true)
    private String name;

    /** The engine class (full name) resposible for generating the profile */
    private String engineClassName;

    /** Parameters required by the engine, if necessary. If present, the system will try to a constructor that receives
     a string as parameter in the configured engine class. **/
    @Lob
    private String params;

    /** Self-instatiated engine, built the first time it is required by the getEngine() method */
    @Transient
    @JsonIgnore
    private ProfileBuilderEngine engine;

    public ProfileBuilder() {
    }

    public ProfileBuilder(String name, String engineClassName) {
        this.name = name;
        this.engineClassName = engineClassName;
    }

    /** Helper method to instantiate and parametrize the associated engine */
    public ProfileBuilderEngine getEngine() {
        if (engine == null) {
            boolean parametrizedConstructor = false;

            try {
                parametrizedConstructor = (Class.forName(this.getEngineClassName()).getConstructor(String.class) != null);
            } catch (NoSuchMethodException | ClassNotFoundException e) {

            }

            try {
                if (parametrizedConstructor) {
                    engine = (ProfileBuilderEngine) Class.forName(this.getEngineClassName()).getConstructor(String.class).newInstance(this.params);
                } else {
                    engine = (ProfileBuilderEngine) Class.forName(this.getEngineClassName()).getConstructor().newInstance();
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return engine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngineClassName() {
        return engineClassName;
    }

    public void setEngineClassName(String engineClassName) {
        this.engineClassName = engineClassName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void setEngine(ProfileBuilderEngine engine) {
        this.engine = engine;
    }
}
