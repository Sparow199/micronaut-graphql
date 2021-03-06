/*
 * Copyright 2017-2019 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package example.graphql;

import example.domain.ToDo;
import example.repository.ToDoRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import javax.inject.Singleton;

/**
 * @author Marcel Overdijk
 */
@Singleton
@SuppressWarnings("Duplicates")
public class CreateToDoDataFetcher implements DataFetcher<ToDo> {

    private ToDoRepository toDoRepository;

    public CreateToDoDataFetcher(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public ToDo get(DataFetchingEnvironment env) {
        String title = env.getArgument("title");
        ToDo toDo = new ToDo(title);
        return toDoRepository.save(toDo);
    }
}
