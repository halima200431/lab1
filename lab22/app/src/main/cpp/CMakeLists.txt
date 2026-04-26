cmake_minimum_required(VERSION 3.22.1)

project("jnidemo")

add_library(
        jnidemo
        SHARED
        native-lib.cpp)

find_library(
        log-lib
        log)

target_link_libraries(
        jnidemo
        ${log-lib})